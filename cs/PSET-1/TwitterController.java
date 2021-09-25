package edu.cis.pset1_twitteranalysis.twitter;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.util.Log;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.io.PrintStream;

public class TwitterController
{
    private Twitter twitter;
    private ArrayList<Status> statuses;
    private ArrayList<String> tokens;
    private HashMap<String, Integer> wordCounts;
    ArrayList<String> commonWords;
    private String popularWord;
    private int frequencyMax;
    Context context;

    public TwitterController(Context currContext)
    {
        context = currContext;

        ConfigurationBuilder cb =  new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("L2BKElNco18WhHak3NkCM05t4")
                .setOAuthConsumerSecret("DXL2KqEegX03uJbQNPxecGFqPiKUhw5vCpnzukiL3OvxFaJIiF")
                .setOAuthAccessToken("1042321525901152256-Po8en0crJfjW74hUWUgKt34n5AAAlP")
                .setOAuthAccessTokenSecret("74bEpnfXM8O3Or3kajQERMeTjJVoYJFGXamUa5qDopE7y");;
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
        statuses = new ArrayList<Status>();
        tokens = new ArrayList<String>();
        wordCounts = new HashMap<>();
        commonWords = new ArrayList<String>();
        getCommonWords();
    }

    /********** PART 1 *********/

    //can be used to get common words from the commonWords txt file
    public void getCommonWords() {

        try {
            AssetManager am = context.getAssets();
            //this file can be found in src/main/assets
            InputStream myFile = am.open("commonWords.txt");
            Scanner sc = new Scanner(myFile);
            while (sc.hasNextLine()) {
                commonWords.add(sc.nextLine());
            }
        } catch (Exception err) {
            Log.d("COMMON_WORDS", err.toString());
        }
    }

    public String postTweet(String message)
    {
        String statusTextToReturn = "";
        try
        {
            Status status = twitter.updateStatus(message);
            statusTextToReturn = status.getText();
        }
        catch (TwitterException e){
            System.out.println(e.getErrorMessage());
        }
        return statusTextToReturn;
    }

    // Example query with paging and file output.
    private void fetchTweets(String handle)
    {


        //Create a twitter paging object that will start at page 1 and hole 200 entries per page.
        Paging page = new Paging(1, 200);

        //Use a for loop to set the pages and get the necessary tweets.
        for (int i = 1; i <= 10; i++)
        {
            page.setPage(i);

            /* Ask for the tweets from twitter and add them all to the statuses ArrayList.
            Because we set the page to receive 200 tweets per page, this should return
            200 tweets every request. */
            try{
                statuses.addAll(twitter.getUserTimeline(handle, page));
            }
            catch (Exception err)
            {
                Log.d("fetchTweets", "could not get user timeline");
            }
        }

        //Write to the file a header message. Useful for debugging.
        int numberOfTweetsFound = statuses.size();
        System.out.println("Number of Tweets Found: " + numberOfTweetsFound);

        //Use enhanced for loop to print all the tweets found.
        int count = 1;
        for (Status tweet : statuses)
        {
            System.out.println(count+". "+tweet.getText());
            count++;
        }
    }

    /********** PART 2 *********/

    /*
     * TODO 2: this method splits a whole status into different words. Each word
     * is considered a token. Store each token in the "tokens" arrayList
     * provided. Loop through the "statuses" ArrayList.
     */
    private void splitIntoWords()
    {
        for(Status status : statuses) { //Loop through statuses
            String[] word = status.getText().split(" "); //New array to get the text and split it by " "
            for (String words : word) //loop through word
                tokens.add(word); //add word to token
        }
    }


    /*
     * TODO 3: return a word after removing any punctuation and turn to lowercase from it.
     * If the word is "Edwin!!", this method should return "edwin".
     * We'll need this method later on.
     * If the word is a common word, return null
     */
    @SuppressWarnings("unchecked")
    private String cleanOneWord(String word)
    {
        String clean = word.trim().replaceAll("[^a-zA-z", "").toLowerCase(); //remove extra spaces replace everything non A-Z char and set it to lower case
        for (String commonWord : commonWords){ //loop through common words
            if(clean.equal(commonWord)) //if the clean words is in common Words
            {
                return null;
            }
        }
        return clean;
    }

    /*
     * TODO 4: loop through each word, get a clean version of each word
     * and save the list with only clean words.
     */
    @SuppressWarnings("unchecked")
    private void createListOfCleanWords()
    {
        ArrayList<String> cleanTokens = new ArrayList<String>(); //init new clean arraylist
        for (String token : tokens){ //loop through and add cleaned token to clean tokens
            cleanTokens.add(this.cleanOneWord(token));
        }
        tokens = new ArrayList<String>(cleanTokens);
    }

    /*
     * TODO 5: count each clean word using. Use the frequentWords Hashmap.
     */
    @SuppressWarnings("unchecked")
    private void countAllWords()
    {
        for (String token : tokens){
            if (wordCount.contains(token)){
                int count = wordCount.get(token) +1;
                wordCounts.put(token, count);
            }
            else{
                wordCounts.put(token , 1);
            }
        }
    }

    //TODO 6: return the most frequent word's string in any appropriate format
    @SuppressWarnings("unchecked")
    public String getTopWord()
    {
        int maxCount = 0;
        String result = "";
        for(Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            int count = entry.getValue();
            String word = entry.getKey();
            if (count >= maxCount){
                result = word;
            }
        }
        return result;
    }

    //TODO 7: return the most frequent word's count as an integer.
    @SuppressWarnings("unchecked")
    public int getTopWordCount()
    {
        int maxCount = 0;
        for (int count : wordCount.value()){
            if (count >=maxCount){
                maxCount = count;
            }
        }
        return maxCount;
    }

    public String findUserStats(String handle)
    {
        /*
         * TODO 8: you put it all together here. Call the functions you
         * finished in TODO's 2-7. They have to be in the correct order for the
         * program to work.
         * Remember to use .clear() method on collections so that
         * consecutive requests don't count words from previous requests.
         */
        this.splitIntoWords();
        this.createListOfCleanWords();
        this.countAllWords();
        String mostFreqword = this.getTopWord();
        Int maxCount = this.getTopWordCount();
        this.tokens.clear();
        this.statuses.clear();
        this.wordCounts.clear();
        return mostFreqword;
        return maxCount;
    }

    /*********** PART 3 **********/

    //TODO 9: Create your own method that recommends possible teaching candidates.
    // Example: A method that returns 100 tweets from keyword(s).
    public List<Status> searchKeywords(String keywords)
    {
        //Use the Query object from Twitter
        Query query = new Query(keywords);
        query.setCount(100);
        query.setSince("2015-12-1");

        //create an ArrayList to store results, which will be of type Status
        List<Status> searchResults = new ArrayList<>();
        try
        {
            //we try to get the results from twitter
            QueryResult result = twitter.search(query);
            searchResults = result.getTweets();
        }
        catch (TwitterException e)
        {
            //if an error happens, like the connection is interrupted,
            //we print the error and return an empty ArrayList
            e.printStackTrace();
        }
        return searchResults;
    }
    
    public List<Status> searchSchools() {
        // try
        //     {
        //         Query query = new Query();
        //     }
        // catch (TwitterException e);
        String[] Schools = {"MIT", "CIS", "Harvard"};
        List<User> schoolUsers = new ArrayList<User>();
        for (String school : schools){
            List<Users> users = twitter.searchUsers(school, 1);
            for (int i = 0; i < 2; i++) {
                school.users.add(users.get(i));
            }
        }
    }

    public List<User> getPossibleTeachers(User school){
        Long nexCursor = -1;
        ArrayList<User> followers = new ArrayList<User>();
        do {
            PagableResponseList<User> userResponse = twitter.getFollowersList(user.getScreenName, nextCursor);
            nextCursor = userResponse.getNextCursor();
            followers.addAll(userResponse);
        }
        while ( nextCursor > 0);
        Hashmap<Integer, User> potentialTeacher = new Hashmap<>();

        for (User user : followers) {
            String bio = user.getDescription().toLowercase();
            if (bio.contains("education") || 
                bio.contains("teacher") ||
                bio.contains("school") ||
                bio.contains("professor")||
                bio.contains("learning")||
                bio.contains("educator")||
                bio.contains("mentor")||
                bio.contains("coach")||
                bio.contains("researcher")||
                bio.contains("trainer")||
                bio.contains("ed")||
                bio.contains("int'l")||
                bio.contains("ibpyp")||
                bio.contains("myp")||
                bio.contains("ib")||
                bio.contains("nerd")||
                bio.contains("history")||
                bio.contains("english")||
                bio.contains("bio")||
                bio.contains("biology")||
                bio.contains("chemistry")||
                bio.contains("cs")||
                bio.contains("physics")||
                bio.contains("math")||
                bio.contains("counselor"))
                {
                    potentialTeacher.put(user.getFollowersCount(), user);
                }
        }
        return potentialTeacher;
    }
    public List<User> getTopThreeTeachers(HashMap<Integer, User> popularTeacher)
    {
        ArrayList<Integer> numberOfFollowers = popularTeacher.keys();
        Collections.sort(numberOfFollowers);
        ArrayList<User> teachers = new ArrayList<User>();
        for (int i = 0; i < 3; i++){
            teacher.add(popularTeacher.get(numberOfFollowers.get(i)));
        }
        return teachers;
    }

    public List<User> getRecommendations()
    {
        List<user> schools = this.searchSchools();
        List<User> recommendation = new ArrayList<User>();
        for (User school: schools){
            HashMap<Integer, User> potentialTeacher = this.getPossibleTeachers(school);
            List<User> topThree = this.topThreeTeachers(potentialTeacher);
            recommendation.addAll(topThree);
        }
        system.out.println(recommendation);
        return recommendation;
    }
}

