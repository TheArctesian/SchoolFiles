package edu.cis.pset1_twitteranalysis.twitter;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import edu.cis.pset1_twitteranalysis.ConsoleColors;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.InputStream;
import java.util.*;

public class TwitterController {
    private Twitter twitter;
    private ArrayList<Status> statuses;
    private ArrayList<String> tokens;
    private HashMap<String, Integer> wordCounts;
    ArrayList<String> commonWords;
    private String popularWord;
    private int frequencyMax;
    Context context;

    public TwitterController(Context currContext) throws TwitterException {
//        API_STATS_CALCULATOR.start();
        context = currContext;

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("L2BKElNco18WhHak3NkCM05t4")
                .setOAuthConsumerSecret("DXL2KqEegX03uJbQNPxecGFqPiKUhw5vCpnzukiL3OvxFaJIiF")
                .setOAuthAccessToken("1042321525901152256-Po8en0crJfjW74hUWUgKt34n5AAAlP")
                .setOAuthAccessTokenSecret("74bEpnfXM8O3Or3kajQERMeTjJVoYJFGXamUa5qDopE7y");
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
        statuses = new ArrayList<Status>();
        tokens = new ArrayList<String>();
        wordCounts = new HashMap<String, Integer>();
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
            Log.d(ConsoleColors.PURPLE + "COMMON_WORDS", err.toString() + ConsoleColors.RESET);
        }
    }

    public String postTweet(String message) {
        String statusTextToReturn = "";
        try {
            Status status = twitter.updateStatus(message);
            statusTextToReturn = status.getText();
        } catch (TwitterException e) {
            System.out.println(e.getErrorMessage());
        }
        return statusTextToReturn;
    }

    // Example query with paging and file output.
    private void fetchTweets(String handle) {
        //Create a twitter paging object that will start at page 1 and hole 200 entries per page.
        Paging page = new Paging(1, 200);
        //Use a for loop to set the pages and get the necessary tweets.
        for (int i = 1; i <= 10; i++) {
            page.setPage(i);
            /* Ask for the tweets from twitter and add them all to the statuses ArrayList.
            Because we set the page to receive 200 tweets per page, this should return
            200 tweets every request. */
            try {
                statuses.addAll(twitter.getUserTimeline(handle, page));
            } catch (Exception err) {
                Log.d("fetchTweets", "could not get user timeline");
            }
        }
        //Write to the file a header message. Useful for debugging.
        int numberOfTweetsFound = statuses.size();
        System.out.println("Number of Tweets Found: " + numberOfTweetsFound);
        //Use enhanced for loop to print all the tweets found.
        int count = 1;
//        for (Status tweet : statuses) {
//            System.out.println(count + ". " + tweet.getText());
//            count++;
//        }
    }

    /********** PART 2 *********/
    // Splits status into strings
    private void splitIntoWords() {
        for (Status tweet : statuses) {
            String word = tweet.getText();
            String[] words = word.split(" ");
            for (int i = 0; i < words.length; i++)
                tokens.add(words[i]);
        }
        //System.out.println(tokens + ConsoleColors.CYAN + "a lof of words hear" + ConsoleColors.RESET);
    }

    // remove punctuation and set all to lower case
    @SuppressWarnings("unchecked")
    private String cleanOneWord(String word) {
        //remove extra spaces replace everything non A-Z char and set it to lower case
        String clean = word.trim().replaceAll("[^a-zA-z]", "").toLowerCase();
        for (String commonWord : commonWords) {
            if (clean.equals(commonWord)
                    || clean.equals("")) {
                return null;
            }
        }
//        System.out.println(clean);
        return clean;
    }

    // Loop through token and clean them
    @SuppressWarnings("unchecked")
    private void createListOfCleanWords() {
        ArrayList<String> cleanTokens = new ArrayList<String>();
        for (String token : tokens) {
            //loop through and add cleaned token to clean tokens
            if (this.cleanOneWord(token) != null)
                cleanTokens.add(this.cleanOneWord(token));
        }
        // AddALL was not working for me idk why but this works fine
        tokens.clear();
        for (int i = 0; i < cleanTokens.size(); i++) {
            tokens.add(cleanTokens.get(i));
        }
//        System.out.println(tokens);
    }

    //add word and freq to hashmap
    @SuppressWarnings("unchecked")
    private void countAllWords() {
        for (String token : tokens) {
            if (wordCounts.containsKey(token)) {
                int count = wordCounts.get(token) + 1;
                wordCounts.put(token, count);
            } else {
                wordCounts.put(token, 1);
            }
        }
//        System.out.println(wordCounts);
    }

    // return most freq word
    @SuppressWarnings("unchecked")
    public String getTopWord() {
        int maxCount = 0;
        String topWord = "";
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            int count = entry.getValue();
            String word = entry.getKey();
            if (count >= maxCount) {
                maxCount = count;
                topWord = word;
            }
        }
        return topWord;
    }

    // return most freq word count
    @SuppressWarnings("unchecked")
    public int getTopWordCount() {
        int maxCount = 0;
        for (int count : wordCounts.values()) {
            if (count >= maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }

    //Call all the methods
    public String findUserStats(String handle) {
        this.fetchTweets(handle);
        this.splitIntoWords();
        this.createListOfCleanWords();
        this.countAllWords();
        String mostFeqWord = this.getTopWord();
        int wordCount = this.getTopWordCount();
        this.tokens.clear();
        this.statuses.clear();
        this.wordCounts.clear();
        System.out.println(handle + "s most common word is: " + mostFeqWord + " it came up " + wordCount + " times");
        return mostFeqWord + wordCount;
    }

    /*********** PART 3 **********/
    //TODO 9: Create your own method that recommends possible teaching candidates.
    // Example: A method that returns 100 tweets from keyword(s).
    public List<Status> searchKeywords(String keywords) {
        //Use the Query object from Twitter
        Query query = new Query(keywords);
        query.setCount(100);
        query.setSince("2015-12-1");
        //create an ArrayList to store results, which will be of type Status
        List<Status> searchResults = new ArrayList<>();
        try {
            //we try to get the results from twitter
            QueryResult result = twitter.search(query);
            searchResults = result.getTweets();
        } catch (TwitterException e) {
            //if an error happens, like the connection is interrupted,
            //we print the error and return an empty ArrayList
            e.printStackTrace();
        }
        return searchResults;
    }

    public String[] schoolHandles() throws TwitterException {
        /**
         * this line is unnecessary but i wanted to show where these came from
         * @schools are some of the top international skls according to some website
         * @SchoolIds are the ids of them, i just used a online translator to do it so i dont have to waste requests
         * */
        String[] SchoolsHandle = {
                "CISHK",
                "DwightSeoul",
                "SJIIES",
                "bisphuket",
                "standrewsbkk",
                "ISHCMC",
                "Elag87",
                "PcarsonPeter"
        };
        return SchoolsHandle;
    }

    public Long[] SchoolsIds() throws TwitterException {
        /**
         * @SchoolIds are the ids of them, i just used a online translator to do it so i dont have to waste requests
         * */
        Long[] SchoolIds = {
                1261034114L,
                496595545L,
                1427407885L,
                88366282L,
                770468923720470528L,
                348214565L,
                164050973L,
                493136102L
        };
        return SchoolIds;
    }

    /**
     * @return re
     * @throws TwitterException
     */


    public HashMap<String, ArrayList<Long>> followersIds(int arrayIndex) throws TwitterException {
        ArrayList<Long> followers = new ArrayList<Long>();
        long cursor = -1L;
        IDs ids;
        Long[] SklsIds = this.SchoolsIds();
//        for (Long identlong : SklsIds) {
        do {
            if (0 < 1) {
                ids = twitter.getFriendsIDs(SklsIds[arrayIndex], cursor);
            } else {
                ids = twitter.getFriendsIDs(cursor);
            }
            for (long id : ids.getIDs()) {
                followers.add(id);
//                    System.out.println(id);
            }
        } while ((cursor = ids.getNextCursor()) != 0);
//        }

        String[] Schools = this.schoolHandles();

        HashMap<String, ArrayList<Long>> sklsIds = new HashMap<String, ArrayList<Long>>();
        sklsIds.put(Schools[arrayIndex], followers);
//        System.out.println(sklsIds);
        return sklsIds;
    }

    public ArrayList<User> ListOfPossibleTeachers(int arrayIndex) throws TwitterException {
        HashMap<String, ArrayList<Long>> sklsIds = this.followersIds(arrayIndex);
        ArrayList<User> users = new ArrayList<User>();
        Collection<ArrayList<Long>> followerid = sklsIds.values();
        for (ArrayList<Long> ALid : followerid) {
            ArrayList<Long> placeholderForIds = ALid;
            for (Long id : placeholderForIds) {
                users.add(twitter.showUser(id)); //this is way too much data
            }
        }
        return users;
    }

    public ArrayList<User> checkIfIsTeacher(int arrayIndex) throws TwitterException {
        ArrayList<User> followersUser = this.ListOfPossibleTeachers(arrayIndex);
        ArrayList<User> teachers = new ArrayList<User>();
        for (User pteacher : followersUser) {
            String bio = pteacher.getDescription().toLowerCase();
            if (bio.contains("education") ||
                    bio.contains("teacher") ||
                    bio.contains("school") ||
                    bio.contains("professor") ||
                    bio.contains("learning") ||
                    bio.contains("educator") ||
                    bio.contains("mentor") ||
                    bio.contains("coach") ||
                    bio.contains("researcher") ||
                    bio.contains("science") ||
                    bio.contains("trainer") ||
                    bio.contains("ed") ||
                    bio.contains("int'l") ||
                    bio.contains("ibpyp") ||
                    bio.contains("myp") ||
                    bio.contains("ib") ||
                    bio.contains("nerd") ||
                    bio.contains("history") ||
                    bio.contains("english") ||
                    bio.contains("bio") ||
                    bio.contains("biology") ||
                    bio.contains("chemistry") ||
                    bio.contains("cs") ||
                    bio.contains("physics") ||
                    bio.contains("math") ||
                    bio.contains("counselor")) {
                teachers.add(pteacher);
//                System.out.println("is a teacher");

            } else {
//                System.out.println("is not a teacher");
            }
        }
        System.out.println(teachers.size());
        return teachers;
    }

    //
    public HashMap<Integer, User> getPossibleTeachersFollowers(int arrayIndex) throws TwitterException {
        ArrayList<User> teachers = this.checkIfIsTeacher(arrayIndex);
        HashMap<Integer, User> teacherRank = new HashMap<>();
        for (User teacher : teachers) {
            teacherRank.put(teacher.getFollowersCount(), teacher);
        }
//        System.out.println(teacherRank);
        return teacherRank;
}

    public ArrayList<User> getTeacherRec(int arrayIndex) throws TwitterException {
        HashMap<Integer, User> teacherRank = this.getPossibleTeachersFollowers(arrayIndex);
        ArrayList<User> teacherReco = new ArrayList<User>();
        Set<Integer> teachersKeySet = teacherRank.keySet();
        ArrayList<Integer> numberOfFollowers = new ArrayList<Integer>(teachersKeySet);
        Collections.sort(numberOfFollowers);
        for (int i = 20; i < 40; i++) {
            teacherReco.add(teacherRank.get(numberOfFollowers.get(i)));
//            System.out.println("added");
//            System.out.println(teacherReco);
        }
//        System.out.println(teacherReco + "should be teachers");
        return teacherReco;
    }

    public ArrayList<String> getTeacherName(int arrayIndex) throws TwitterException {
        ArrayList<User> teacherRank = this.getTeacherRec(arrayIndex);
        ArrayList<String> teacherScreenName = new ArrayList<String>();
        for (User user : teacherRank) {
            teacherScreenName.add(user.getName());
        }
//        System.out.println(teacherScreenName);
        return teacherScreenName;
    }

    public ArrayList<String> getTeacherDescription(int arrayIndex) throws TwitterException {
        ArrayList<User> teacherRank = this.getTeacherRec(arrayIndex);
        ArrayList<String> teacherDiscription = new ArrayList<String>();
        for (User user : teacherRank) {
            String bio = user.getDescription();
            teacherDiscription.add(bio);
        }
//        System.out.println(teacherDiscription);
        return teacherDiscription;
    }
    public ArrayList<String> getTeacherPhoto(int arrayIndex) throws TwitterException {
        ArrayList<User> teacherRank = this.getTeacherRec(arrayIndex);
        ArrayList<String> teacherPhotos = new ArrayList<String>();
        for (User user : teacherRank) {
            String photo = user.getDescription();
            teacherPhotos.add(photo);
        }

//        System.out.println(teacherPhotos);
        return teacherPhotos;
    }

//    public HashMap<String, String> TeacherInfoForGui (int arrayIndex) throws TwitterException {
//        HashMap<String, String> teacherInfo = new HashMap<String, String>();
//        ArrayList<String> teacherName = this.getTeacherUserName(arrayIndex);
//        ArrayList<String> teacherDiscription = this.getTeacherDescription(arrayIndex);
//        ArrayList<String> TeacherPhoto = this.getTeacherPhoto(arrayIndex);
//        int i = 0;
//        for (String teacherD : teacherDiscription){
//            teacherInfo.put(teacherD, teacherName.get(i));
//            i++;
//        }
//        System.out.println(TeacherPhoto);
//        System.out.println(teacherInfo);
//        System.out.println("ENDNEDNENDENDNENDNEDNEND");
//        return teacherInfo;
//    }
//    public Image getProfileImage(User user){
//        URL url = user.getProfileImageURL();
//        ImageIcon img = new ImageIcon(url);
//        return Image;
//    }


//    public List<User> getRecommendations() throws TwitterException {
//        //List<User> schools = this.searchSchools();
//        List<User> recommendation = new ArrayList<User>();
//        System.out.println(recommendation);
////        for (User school : schools) {
////            HashMap<Integer, User> potentialTeacher = this.getPossibleTeachers(school);
////            List<User> topThree = this.getTopThreeTeachers(potentialTeacher);
////            recommendation.addAll(topThree);
////        }
////        System.out.println(topThree.toString());
//        return recommendation;
//    }

//    public void stats(){
//        API_STATS_CALCULATOR.getAvarageTIme();
//    }
}
