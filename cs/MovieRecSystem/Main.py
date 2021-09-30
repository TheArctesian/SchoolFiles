import PySimpleGUI as sg
import sys
import os
import random

# pngFileNames = ['/spiderman.png']
# animation 3, romance 14, drama 8, horror 11, thriller 16, action 1, adventure 2, crime 6, film-noir 10
movieNames = ['Toy Story', 'Titanic', 'Shawshank Redemption', 'Saw', 'Taxi Driver', 'John Wick', 'Finding Nemo',
              'The Godfather'
    , 'Citizen Kane', ]
genID = [3, 14, 8, 11, 16, 1, 2, 6, 10]


def createRatingsList(numUsers, numMovies):
    file = open("u.data", "r")  # open and set mode to read
    filelines = file.readlines()  # read files
    userRatings = [{} for _ in range(numUsers)]  #creat list of d
    movieRatings = [{} for _ in range(numMovies)]
    for line in filelines:
        line = line.split() #split by ' '
        uid = int(line[0]) #org data into ds
        mid = int(line[1])
        rating = int(line[2])
        userRatings[uid - 1][mid] = rating #because lists start at 0
        movieRatings[mid - 1][uid] = rating
    return userRatings, movieRatings


def createUserList():
    file = open("u.user", "r")  #open and read file
    filelines = file.readlines() #split lines
    userList = [] #initialize user list
    for line in filelines:
        line = line[:-1].split("|")  #split lines by |
        d = {'age': int(line[1]), 'gender': line[2], 'occupation': line[3], 'zip': line[4]}
        userList.append(d) #append d to list of users

    return userList


def createMovieList():
    file = open("u.item", "r", errors='ignore') #open and read file ingnore errors
    filelines = file.readlines() #split lines
    movieList = [] #initialize movie list

    for line in filelines:
        line = line[:-1].split("|") #get rid of the/n split
        genre = []
        for i in range(5, 24):
            genre.append(int(line[i]))
        d = {'title': line[1], 'release date': line[2], 'video release date': line[3], 'IMDB url': line[4],
             'genre': genre}
        movieList.append(d) #append d to list of movie

    return movieList


def createGenreList():
    file = open("u.genre", "r") #open and read file
    filelines = file.readlines() #split lines
    genreList = [] #initialize movie list

    for line in filelines:
        line = line.split("|") #split by |
        genreList.append(line[0]) #append
    del genreList[-1]  #list starts at 0

    return genreList


def meanUserRating(u, userRatings):
    if u < 1:
        print("Error! ID of user should be larger than 1.") #if uts not a user
        return

    rating_dict = userRatings[u - 1] #get users ratings
    x = 0

    for val in rating_dict.values(): # loop through all the values of the user rating dictionary

        x += val

    return x / len(rating_dict) #get avg


def meanMovieRating(u, movieRatings): #same a s meanuserrating
    if u < 1:
        print("Error! ID of movie should be larger than 1.")
        return

    rating_dict = movieRatings[u - 1]
    if len(rating_dict) < 10:
        print("Movie ID ", u, "does not have more than 10 ratings.")
        return
    x = 0
    for val in rating_dict.values():  # loop through all the values of the user rating dictionary
        x += val
    return x / len(rating_dict)


def moviesInGenre(genre, movieList):
    l = [] #initialize list

    for movie in movieList:
        if movie['genre'][genre] == 1: #the amount of genres
            l.append(movie['title']) #append to list

    return sorted(l) #sort list


def popularMoviesInGenre(genre, movieList, movieRatings):
    res = [] #initialize list

    for movie in movieList:
        if movie['genre'][genre] == 1: #if movie is in genre
            index = movieList.index(movie) #getting index

            if len(movieRatings[index]) >= 20: #calling on the index in movie ratings to get the rating, but has at least 20 ratings
                tmp = (movie['title'], meanMovieRating(index + 1, movieRatings)) #movie title and mean rating of the movie
                res.append(tmp)
    return sorted(res, key=lambda tup: tup[1], reverse=True) #sort list decendingly by mean rating
    '''
    lambda is a samall ananonymous function, below is the format:
    lambda arg1, arg2, ... : expression

    In the sorted() function, the key specifies the 'key' you want the sorted() function to sort by, a value of a key parameter 
    should be another function
    '''


def meanGenreRating(genre, movieList, movieRatings):
    x = 0
    counter = 0
    for movie in movieList:
        if movie['genre'][genre] == 1: # if in the genre we want
            index = movieList.index(movie) #getting the index of the movie in movie list
            rating_dict = movieRatings[index] #calling on the index in movie ratings to get the rating
            for val in rating_dict.values(): #looping through values
                x += val #rating
                counter += 1 #counting the num of movies in a genre
    return x / counter #get mean genre rating


def popularGenres(genreList, movieList, movieRatings):
    l = [] #result
    res = [] #to sort result

    for i in range(len(genreList)): #the amount of genres
        tmp = (genreList[i], meanGenreRating(i, movieList, movieRatings)) #getting genre name and mean genre ratin
        l.append(tmp) #append tuple to list
    l = sorted(l, key=lambda tup: tup[1], reverse=True) #sort list decendingly by mean rating

    for i, j in l: #i = first element of tuple, j = second element of tuple l = third element in tuple
        res.append(i)

    return res


def createOccupationList():
    l = []
    file = open('u.occupation', 'r')
    filelines = file.readlines()
    for line in filelines:
        line = line[:-1] #get rid of the/n
        l.append(line)
    return l


def occupationRec(occupation, userList, userRatings, movieList):
    uid = []
    for i in range(len(userList)):
        if userList[i]['occupation'] == occupation: #get the index for the UID with 'occupation'
            uid.append(i) #append the index to uid
    movie_ids = set() #ins a set (list with no repeating values)
    for index in uid: #for the index cuz if it was value they would all be one off
        for key, val in userRatings[index].items():
            if val == 5 or val == 4: #only chose movies that have been rated over 4 in the occupation
                movie_ids.add(key)
    id_with_ratings = []
    for mid in movie_ids:
        counter = 0
        tmp = 0.0
        for index in uid:
            try:
                rating = userRatings[index][mid]
                tmp += rating
                counter += 1
            except:
                continue
        if counter >= 10:
            id_with_ratings.append((mid, tmp / counter)) #append mid and avg into list

    id_with_ratings = sorted(id_with_ratings, key=lambda tup: tup[1], reverse=True) #sort in decend order

    titles = []
    breaker = 0
    for mid, rating in id_with_ratings:
        if breaker == 5:
            break
        titles.append(movieList[mid - 1]['title']) #add title to movies
        breaker += 1
    return titles


def genderRec(gender, userList, userRatings, movieList):
    uid = []
    for i in range(len(userList)):
        if userList[i]['gender'] == gender: #get the index for the UID with 'gender'
            uid.append(i) #append the index to uid
    movie_ids = set() #in a set (list with no repeating values)
    for index in uid: #some movies might not meet requirments
        for key, val in userRatings[index].items():
            if val == 5 or val == 4:
                movie_ids.add(key)

    id_with_ratings = [] #empty list to store titles of movies
    for mid in movie_ids:
        counter = 0
        tmp = 0.0 #float to go the exact rating
        for index in uid:
            try:
                rating = userRatings[index][mid]
                tmp += rating
                counter += 1
            except:
                continue
        if counter >= 10: #has to be over 10 ratings
            id_with_ratings.append((mid, tmp / counter)) #append mid and avg into list

    id_with_ratings = sorted(id_with_ratings, key=lambda tup: tup[1], reverse=True)  #sort in decend order

    titles = []
    breaker = 0
    for mid, rating in id_with_ratings:
        if breaker == 5:
            break
        titles.append(movieList[mid - 1]['title']) #add title to movies
        breaker += 1
    return titles


def popup_select(the_list, select_multiple=False):
    layout = [[sg.Listbox(the_list, key='_LIST_', size=(45, len(the_list)),
                          select_mode='extended' if select_multiple else 'single', bind_return_key=True),
               sg.OK()]]  # initialize the buttons
    window = sg.Window('Select One', layout=layout)  # match layout
    event, values = window.read()  # read values
    window.close()
    del window #delete window when closed
    if select_multiple or values['_LIST_'] is None:
        return values['_LIST_']
    else:
        return values['_LIST_'][0]


"""" #attempting to open a image in gui didnt work 
def popup_image():
	img_name = pngFileNames[0]
	layout = [[sg.Image(filename=os.getcwd()+img_name, key='-IMAGE-', size=(500, 500))], [sg.Button('Poster 1')]]
	window = sg.Window('Select One', layout=layout, finalize=True)
	event, value = window.read()
	window.close()
	del window
	if event == 'Poster 1':
		return 1
	elif event == 'Poster 2':
		return 2
	return -1
"""


def randomRec(movieList, movieRatings):
    result = []
    choices = random.sample(movieNames, 6) #pick 6 sample movies
    for i in range(0, 6, 2):
        layout = [[sg.Text(choices[i])], [sg.Button("Movie 1")], [sg.Text(choices[i + 1])], [sg.Button("Movie 2")]] #create buttons
        window = sg.Window('Select One Movie', layout=layout) #initalize layout
        event, values = window.read() #get valus of user
        window.close() #clost windows when done
        del window
        if event == 'Movie 1':  #append the users choice of movie(genre) to result
            result.append(genID[movieNames.index(choices[i])])
        else:
            result.append(genID[movieNames.index(choices[i + 1])])
    genre_choice = random.choice(result) #pick a random genre out of the genre that the user liked
    popularChoices = popularMoviesInGenre(genre_choice, movieList, movieRatings)
    return random.choice(popularChoices) #get random movie from other function


# initialize functions
userList = createUserList()
movieList = createMovieList()
userRatings, movieRatings = createRatingsList(len(userList), len(movieList))
genreList = createGenreList()

sg.theme('DarkAmber')  # Add a color to the gui
# All the elements inside the window
functions = ('Mean User Rating', 'Mean Movie Rating', 'Movies in Genre', 'Popular Movies in Genre', 'Mean Genre Rating',
             'Popular Genres',
             'Movie Recommendations', 'User Rec Gender', 'User Rec Occupation', 'Poster test')
#create buttons
layout = [[sg.Text("Select a Function under the list below!")],
          [sg.Button('Mean User Rating')],
          [sg.Button('Mean Movie Rating')],
          [sg.Button('Popular Movies in Genre')],
          [sg.Button('Movies in Genre')],
          [sg.Button('Mean Genre Rating')],
          [sg.Button('Popular Genres')],
          [sg.Button('User Rec Gender')],
          [sg.Button('User Rec Occupation')],
          [sg.Button('Random Rec')],
          [sg.Button('Cancel')]]

gender_list = ['M', 'F']

occu_list = createOccupationList()
# Create the Window
window = sg.Window('Movies', layout)
# Event Loop to process "events" and get the "values" of the inputs
while True:
    event, values = window.read()
    print(event, values)
    if event == sg.WIN_CLOSED or event == 'Cancel':  # if user closes window or clicks cancel
        break
    if event == 'Mean User Rating':  # if button mean user rating is pressed
        uid = sg.popup_get_text("Input the user ID:")  # display input user id:
        try:
            output = meanUserRating(int(uid), userRatings)  # use fuction for meanUserrating() to get output
            sg.popup("Mean user rating is: ", output)  # display output
        except:  # if something is wrong
            sg.popup("Try to input something sensible next time!")  # display error messege with joke
            print("Error!")
    if event == 'Mean Movie Rating':
        mid = sg.popup_get_text("Input the movie ID:")
        try:
            output = meanMovieRating(int(mid), movieRatings)
            sg.popup("Mean movie rating is: ", output)
        except:
            sg.popup("Try to input something sensible next time!")
            print("Error!")
    if event == 'Popular Movies in Genre':
        gid = sg.popup_get_text("Input the genre ID:")
        try:
            output = popularMoviesInGenre(int(gid), movieList, movieRatings)
            sg.popup("Popular movies in the genre is: ", output)
        except:
            print("Error!")
    if event == 'Movies in Genre':
        gid = sg.popup_get_text("Input the genre ID:")
        try:
            output = moviesInGenre(int(gid), movieList)
            sg.popup("Movies in the genre is: ", output)
        except:
            print("Error!")
    if event == 'Mean Genre Rating':
        gid = sg.popup_get_text("Input the genre ID:")
        try:
            output = meanGenreRating(int(gid), movieList, movieRatings)
            sg.popup("Mean genre rating is: ", output)
        except:
            print("Error!")
    if event == 'Popular Genres':
        try:
            output = popularGenres(genreList, movieList, movieRatings)
            sg.popup("Popular genres are: ", output)
        except:
            print("Error!")
    if event == 'User Rec Gender':
        gender = popup_select(gender_list)
        try:
            output = genderRec(gender, userList, userRatings, movieList)
            sg.popup("Reccomended films are: ", output)
        except:
            print("Error!")
    if event == 'User Rec Occupation':
        occupation = popup_select(occu_list)
        try:
            output = occupationRec(occupation, userList, userRatings, movieList)
            sg.popup("Reccomended films are: ", output)
        except:
            print("Error!")
    if event == 'Random Rec':
        try:
            movie = randomRec(movieList, movieRatings)
            sg.popup("Random Reccomendation: ", movie)
        except:
            print("Error!")
window.close()

