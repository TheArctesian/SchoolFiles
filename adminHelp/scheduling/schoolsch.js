{
    {
        /*
         * CIS AUTO CALENDAR: USER IMPORT
         * This file contiains the code used to run the user import page in the CISAutoCalendar Website
         * Author: Adrian Ngan (CIS Class of 2022)
         */

        //--------------- USER INPUT AND SCHEUDLE OBJECT CREATOR SECTION ---------------
        // Initialzing Google Calendar API
        // Client ID and API key from the Developer Console
        var CLIENT_ID = '1097932129420-mkla5e9ibr6qgok18dvn3ac3f2a4f9in.apps.googleusercontent.com';
        var API_KEY = 'AIzaSyBqafLKv1Y-SktNmuvb651BvR48UAXd96A';    

        // Array of API discovery doc URLs for APIs
        var DISCOVERY_DOCS = ["https://www.googleapis.com/discovery/v1/apis/calendar/v3/rest"];
        var SCOPES = "https://www.googleapis.com/auth/calendar.events";

        var authorizeButton = document.getElementById('authorize_button');
        var signoutButton = document.getElementById('signout_button');
        var nextButton = document.getElementById('next_button');
        var step0and1 = document.getElementById('step0and1');
        var step2and3 = document.getElementById('step2and3');
        var step4 = document.getElementById('step4');
        var loginDiv = document.getElementById("loginDiv");
        var inputDiv = document.getElementById("inputDiv");
        var disabledDiv = document.getElementById("disabledDiv");

        //Intializing Firebase
        var firebaseConfig = {
            apiKey: "AIzaSyBqafLKv1Y-SktNmuvb651BvR48UAXd96A",
            authDomain: "ia2022-autocalendar.firebaseapp.com",
            projectId: "ia2022-autocalendar",
            storageBucket: "ia2022-autocalendar.appspot.com",
            messagingSenderId: "1097932129420",
            appId: "1:1097932129420:web:21fd9c663d25f4efbd67a9",
            measurementId: "G-R853YPF8FT"
        };

        firebase.initializeApp(firebaseConfig);
        var db = firebase.firestore();

        // Firestore data converter
        var settingConverter = {
            toFirestore: function (settings) {
                return {
                    startDate: settings.startDate,
                    endDate: settings.endDate,
                    cycleNum: settings.cycleNum,
                    periodNum: settings.periodNum,
                    cycleNames: settings.cycleNames,
                    periodTimes: settings.periodTimes,
                    calendarCSV: settings.calendarCSV,
                    step0Heading: settings.step0Heading,
                    step0Instructions: settings.step0Instructions,
                    step1Heading: settings.step1Heading,
                    step1Instructions: settings.step1Instructions,
                    step1InstructionsLoggedIn: settings.step1InstructionsLoggedIn,
                    step2Heading: settings.step2Heading,
                    step2Instructions: settings.step2Instructions,
                    step3Heading: settings.step3Heading,
                    step3Instructions: settings.step3Instructions,
                    step4Heading: settings.step4Heading,
                    step4Instructions: settings.step4Instructions,
                    password: settings.password,
                    enableSite: settings.enableSite
                };
            },
            fromFirestore: function (snapshot, options) {
                const data = snapshot.data(options);
                return new Settings(data.startDate, data.endDate, data.cycleNum, data.periodNum, data.cycleNames, data.periodTimes, data.calendarCSV,
                    data.step0Heading, data.step0Instructions, data.step1Heading, data.step1Instructions, data.step1InstructionsLoggedIn,
                    data.step2Heading, data.step2Instructions, data.step3Heading, data.step3Instructions, data.step4Heading, data.step4Instructions,
                    data.password, data.enableSite);
            }
        };

        //Intializing and getting varibles from settings (from Firebase)
        var startDate;
        var endDate;
        var periodNum;
        var daysNum;
        var cycledayNames;
        var periodTimes;
        var calendarCSV;
        var step0Heading;
        var step0Instructions;
        var step1Heading;
        var step1Instructions;
        var step1InstructionsLoggedIn;
        var step2Heading;
        var step2Instructions;
        var step3Heading;
        var step3Instructions;
        var step4Heading;
        var step4Instructions;
        var password;
        var enableSite;
        var userInputs = [];
        var userSchedule;
        var fakeUserinputs = [
            ["Econ", "Econ", "CS", "Chem"],
            ["2Econ", "2Econ", "2CS", " "],
            ["3Econ", "3Econ", "3CS", "3Chem"],
            ["E4con", "4Econ", "4CS", "4Chem"],
            ["5Econ", "5Econ", "5CS", "5Chem"],
            ["6Econ", "6Econ", "6CS", "6Chem"],
            ["7Econ", "7Econ", "7CS", "7Chem"],
            ["8Econ", "8Econ", "8CS", "8Chem"]
        ];

        // -----------------------FUNCTIONS------------------------
        //This function creates a new table for user schedule inputs and calls generateTableForm
        //This function is called when the page is loaded. The table created contiains input fields  
        //for the user to input the name of the period they have at each slot
        function createTableForm() {

            var dateRangeText = document.getElementById("dateRangeText");
            dateRangeText.textContent = "Currently creates schedule from " + startDate + " to " + endDate + "(YY/MM/DD)";
            var tableDiv = document.getElementById("tableInput");


            var table = document.createElement("table");
            table.setAttribute("class", "table table-bordered table-responsive");
            generateTableForm(table);

            tableDiv.append(table);

            let step0HeadingText = document.getElementById("step0Heading");
            step0HeadingText.innerText = step0Heading;

            let step0InstructionText = document.getElementById("step0Instructions");
            step0InstructionText.innerText = step0Instructions;

            let step1HeadingText = document.getElementById("step1Heading");
            step1HeadingText.innerText = step1Heading;

            let step1InstructionText = document.getElementById("step1Instructions");
            step1InstructionText.innerText = step1Instructions;

            let step1InstructionLoggedInText = document.getElementById("step1InstructionsLoggedIn");
            step1InstructionLoggedInText.innerText = step1InstructionsLoggedIn;

            let step2HeadingText = document.getElementById("step2Heading");
            step2HeadingText.innerText = step2Heading;

            let step2InstructionText = document.getElementById("step2Instructions");
            step2InstructionText.innerText = step2Instructions;

            let step3HeadingText = document.getElementById("step3Heading");
            step3HeadingText.innerText = step3Heading;

            let step3InstructionText = document.getElementById("step3Instructions");
            step3InstructionText.innerText = step3Instructions;

            let step4HeadingText = document.getElementById("step4Heading");
            step4HeadingText.innerText = step4Heading;

            let step4InstructionText = document.getElementById("step4Instructions");
            step4InstructionText.innerText = step4Instructions;

            if (!enableSite) {
                inputDiv.style.display = 'none';
                disabledDiv.style.display = 'block';
            }
        }

        //This function creates the attributes such as input fields and headings within the input table
        function generateTableForm(table) {
            let thead = table.createTHead();
            let columnHeadings = thead.insertRow();
            columnHeadings.setAttribute("class", "table-light");
            let th = document.createElement("th");
            let text = document.createTextNode("Cycle Day");
            th.appendChild(text);
            th.setAttribute("scope", "col");
            columnHeadings.appendChild(th);

            //Column Headings
            for (i = 0; i < periodNum; i++) {
                let th = document.createElement("th");
                let text = document.createTextNode("Period " + (i + 1));
                th.appendChild(text);
                th.setAttribute("scope", "col");
                columnHeadings.appendChild(th);
            }

            //Rows
            for (i = 0; i < daysNum; i++) {
                let row = table.insertRow();
                row.setAttribute("scope", "row");
                let rowLabel = row.insertCell();
                let cycledayName = document.createTextNode(cycledayNames[i]);
                rowLabel.setAttribute("class", "table-light");
                rowLabel.appendChild(cycledayName);

                //Input fields
                for (j = 0; j < periodNum; j++) {
                    let inputCell = row.insertCell();
                    let inputField = document.createElement("input");
                    inputField.setAttribute("type", "text");
                    inputField.setAttribute("id", "day-" + (i + 1) + "-period-" + (j + 1));
                    inputField.setAttribute("maxlength", 50);
                    inputField.setAttribute("class", "border rounded");
                    inputCell.appendChild(inputField);
                }
            }
        }

        //Functions for the API
        //On load, called to load the auth2 library and API client library.
        function handleClientLoad() {
            gapi.load('client:auth2', initClient);
        }

        // Initializes the API client library and sets up sign-in state listeners.
        function initClient() {
            console.log("initializing client");
            gapi.client.init({
                apiKey: API_KEY,
                clientId: CLIENT_ID,
                discoveryDocs: DISCOVERY_DOCS,
                scope: SCOPES
            }).then(function () {

                //Import Settings
                db.collection("Manage").doc("settings")
                    .withConverter(settingConverter)
                    .get().then((doc) => {
                        if (doc.exists) {
                            var settings = doc.data();
                            startDate = settings.startDate;
                            endDate = settings.endDate;
                            periodNum = settings.periodNum;
                            daysNum = settings.cycleNum;
                            cycledayNames = settings.cycleNames;
                            periodTimes = settings.periodTimes;
                            calendarCSV = settings.calendarCSV;
                            step0Heading = settings.step0Heading;
                            step0Instructions = settings.step0Instructions;
                            step1Heading = settings.step1Heading;
                            step1Instructions = settings.step1Instructions;
                            step1InstructionsLoggedIn = settings.step1InstructionsLoggedIn;
                            step2Heading = settings.step2Heading;
                            step2Instructions = settings.step2Instructions;
                            step3Heading = settings.step3Heading;
                            step3Instructions = settings.step3Instructions;
                            step4Heading = settings.step4Heading;
                            step4Instructions = settings.step4Instructions;
                            password = settings.password;
                            enableSite = settings.enableSite;
                            console.log("imported settings");
                            createTableForm();

                            // Listen for sign-in state changes.
                            gapi.auth2.getAuthInstance().isSignedIn.listen(updateSigninStatus);

                            // Handle the initial sign-in state.
                            updateSigninStatus(gapi.auth2.getAuthInstance().isSignedIn.get());
                            authorizeButton.onclick = handleAuthClick;
                            signoutButton.onclick = handleSignoutClick;
                            nextButton.onclick = handleNextClick;
                            console.log("initialized client");

                        } else {
                            console.log("No such document!");
                        }
                    }).catch((error) => {
                        console.log("Error getting document:", error);
                    });
            }, function (error) {
                console.log(error);
            });
        }

        // Called when the signed in status changes, to update the UI appropriately. 
        // After a sign-in, the API is called.
        function updateSigninStatus(isSignedIn) {
            if (!enableSite) {
                disabledDiv.style.display = 'block';
            } else {
                var step1Instructions = document.getElementById('step1Instructions');
                var step1InstructionsLoggedIn = document.getElementById('step1InstructionsLoggedIn');

                step0and1.style.display = 'block';
                inputDiv.style.display = 'none';
                if (isSignedIn) {
                    authorizeButton.style.display = 'none';
                    signoutButton.style.display = 'block';
                    nextButton.style.display = 'block';
                    step1InstructionsLoggedIn.style.display = 'block';
                    step1Instructions.style.display = 'none';

                } else {
                    authorizeButton.style.display = 'block';
                    signoutButton.style.display = 'none';
                    nextButton.style.display = 'none';
                    step1InstructionsLoggedIn.style.display = 'none';
                    step1Instructions.style.display = 'block';
                }
            }

        }

        // Sign in the user upon button click.
        function handleAuthClick(event) {
            gapi.auth2.getAuthInstance().signIn();
        }

        // Sign out the user upon button click.
        function handleSignoutClick(event) {
            gapi.auth2.getAuthInstance().signOut();
        }

        // Handles button click to move from step 1 to 2 and 3
        function handleNextClick(event) {
            authorizeButton.style.display = 'none';
            step0and1.style.display = 'none';
            signoutButton.style.display = 'block';
            inputDiv.style.display = 'block';
            nextButton.style.display = 'none';
            step2and3.style.display = 'block';
            step4.style.display = 'none';
        }

        //This function is called when the user clicks the 'Import' button. It takes the user's inputs and calls importToCalendar
        function submitForm() {
            for (i = 0; i < daysNum; i++) {
                var periodInputs = [];
                for (j = 0; j < periodNum; j++) {
                    periodInputs.push(document.getElementById("day-" + (i + 1) + "-period-" + (j + 1)).value);
                }
                userInputs.push(periodInputs);

            }
            userSchedule = new Schedule(userInputs);
            importToCalendar(userSchedule, document.getElementById("userImportDays").checked);
            step2and3.style.display = 'none';
            step4.style.display = 'block';
        }

        //This function calls the Google Calendar API and sends requests to create the apporiate events in the user's calendar
        async function importToCalendar(schedule, checked) {
            var calendarID = "primary";
            var spinner = document.getElementById("loadingSpinner");
            var step4Status = document.getElementById("step4Status");
            var calendarButtonLink = document.getElementById("calendarButton");
            spinner.style.display = "block";
            var failedRequests = [];
            for (var date in calendarCSV) {
                if (checkDateWithinRange(date)) //Checks if the date in the specified date range
                {
                    var cycleDay = calendarCSV[date];
                    var scheduleDay = schedule.getDay(cycleDay);

                    //Imports Periods
                    for (var i = 0; i < scheduleDay.periods.length; i++) {
                        var schedulePeriod = scheduleDay.periods[i];
                        if (!schedulePeriod.freePeriod) {
                            var dateInput = makeDateString(date);
                            var eventResource = {
                                'summary': schedulePeriod.className,
                                'start': {
                                    'dateTime': dateInput + 'T' + schedulePeriod.startTime + ':00+08:00'
                                },
                                'end': {
                                    'dateTime': dateInput + 'T' + schedulePeriod.endTime + ':00+08:00'
                                }
                            };
                            var request = gapi.client.calendar.events.insert({
                                'calendarId': calendarID,
                                'resource': eventResource
                            });
                            console.log(date);
                            console.log(dateInput)
                            console.log(eventResource);

                            //For the first periods in the day, the function sends each 
                            //request without waiting for a response from the pervious
                            //For the last period, the function calls an async function that 
                            //waits for the 4 total requests sent.
                            //This is to improve the speed of the program (I cant figure out how to make it faster but also reliable).
                            var send = 4;
                            if (scheduleDay.periods[3].freePeriod) {
                                send = 3; //call wait for 3rd period
                                if (scheduleDay.periods[2].freePeriod) {
                                    send = 2; //call wait for 2rd period
                                    if (scheduleDay.periods[1].freePeriod) {
                                        send = 1; //call wait for 1rd period
                                    }
                                }
                            }

                            console.log(send)
                            if (false) {
                                console.log("calling non wait");
                                request.execute(function (event) {
                                    if (event.hasOwnProperty('error')) {
                                        failedRequests.push(request);
                                        console.log(event);
                                        console.log("added to failed")
                                    } else {
                                        console.log(event);
                                    }
                                })
                            } else {
                                console.log("calling wait");
                                var result = await callRequestWait(request);
                                if (result == "fail") {
                                    failedRequests.push(request);
                                }
                            }
                        }
                    }
                    //Imports Cycle Day Events
                    if (checked) {
                        var eventResource = {
                            'summary': cycleDay,
                            'start': {
                                'date': makeDateString(date)
                            },
                            'end': {
                                'date': makeDateString(date)
                            }
                        };
                        var request = gapi.client.calendar.events.insert({
                            'calendarId': calendarID,
                            'resource': eventResource
                        });

                        console.log("calling wait");
                        var result = await callRequestWait(request);
                        if (result == "fail") {
                            failedRequests.push(request);
                        }
                    }
                }
            }

            //If requests fail, they are rerun up to 5 times.
            //If they still fail after 5 retrys, an error msg is displayed
            var count = 5;
            var fail = false;
            while (failedRequests.length != 0) {
                console.log("RERUN: " + count);
                failedRequests = await rerunFailedReq(failedRequests);
                count -= 1;
                if (count == 0) {
                    failedRequests = [];
                    fail = true;
                }
            }
            spinner.style.display = "none";
            calendarButtonLink.style.display = "block";
            if (fail) {
                step4Status.textContent = "There has been an error. Events may be missing";
            } else {
                step4Status.textContent = "Import complete " + String.fromCodePoint(0x2705);
            }

        }

        //This function creates an ISODate string
        function makeDateString(date) {
            var ISODate = "";
            var split = date.split("/");
            for (var i = 2; i > -1; i--) {
                if (i != 0 && split[i].length < 2) {
                    ISODate += "0" + split[i];
                } else {
                    ISODate += split[i];
                }
                if (i != 0) {
                    ISODate += "-";
                }
            }
            return ISODate;
        }

        //This function calls aboveStartDate and belowEndDate to check if the date occurs within the range
        function checkDateWithinRange(date) {
            var date = date.split("/"); //Format: DD/MM/YY
            if (aboveStartDate(date) && belowEndDate(date)) {
                return true;
            } else {
                return false;
            }
        }

        //This function checks if give date occurs after the start date
        function aboveStartDate(date) {
            var startDateArr = startDate.split("-"); //Format: YY-MM-DD
            if (parseInt(date[2]) > parseInt(startDateArr[0])) {
                return true;
            } else if (parseInt(date[2]) == parseInt(startDateArr[0])) {
                if (parseInt(date[1]) > parseInt(startDateArr[1])) {
                    return true;
                } else if (parseInt(date[1]) == parseInt(startDateArr[1])) {
                    if (parseInt(date[0]) >= parseInt(startDateArr[2])) {
                        return true;
                    } else {
                        return false
                    }
                } else {
                    return false
                }
            } else {
                return false;
            }
        }

        //This function checks if give date occurs before the end date
        function belowEndDate(date) {
            var endDateArr = endDate.split("-"); //Format: YY-MM-DD
            if (parseInt(date[2]) < parseInt(endDateArr[0])) {
                return true;
            } else if (parseInt(date[2]) == parseInt(endDateArr[0])) {
                if (parseInt(date[1]) < parseInt(endDateArr[1])) {
                    return true;
                } else if (parseInt(date[1]) == parseInt(endDateArr[1])) {
                    if (parseInt(date[0]) <= parseInt(endDateArr[2])) {
                        return true;
                    } else {
                        return false
                    }
                } else {
                    return false
                }
            } else {
                return false;
            }
        }

        //This function executes a request and returns a promise
        function callRequestWait(request) {
            return new Promise(resolve => {
                request.execute(function (event) {
                    if (event.hasOwnProperty('error')) {
                        console.log(event);
                        resolve("fail");
                    } else {
                        console.log(event);
                        resolve("success");
                    }
                })
            })
        }

        //This function reruns all failed requests
        async function rerunFailedReq(failedRequests) {
            var newFailedRequests = [];
            for (var i = 0; i < failedRequests.length; i++) {
                var result = await callRequestWait(failedRequests[i]);
                if (result == "fail") {
                    newFailedRequests.push(failedRequests[i]);
                }
            }
            return newFailedRequests;
        }

        // --------------- MODELS AND CLASSES ---------------
        /*
         * Settings Class
         * 
         * This class contains information of the school's timetable and settings for the import process.
         * These settings are determined by the admins through the Manage page and is stored in Firebase
         * 
         */
        class Settings {

            startDate;
            endDate;
            cycleNum;
            periodNum;
            cycleNames;
            periodTimes;
            calendarCSV;
            step0Heading;
            step0Instructions;
            step1Heading;
            step1Instructions;
            step1InstructionsLoggedIn;
            step2Heading;
            step2Instructions;
            step3Heading;
            step3Instructions;
            step4Heading;
            step4Instructions;
            password;
            enableSite;

            constructor(startDate, endDate, cycleNum, periodNum, cycleNames, periodTimes, calendarCSV, step0Heading, step0Instructions,
                step1Heading, step1Instructions, step1InstructionsLoggedIn, step2Heading, step2Instructions, step3Heading, step3Instructions,
                step4Heading, step4Instructions, password, enableSite) {
                this.startDate = startDate;
                this.endDate = endDate;
                this.cycleNum = cycleNum
                this.periodNum = periodNum;
                this.cycleNames = cycleNames;
                this.periodTimes = periodTimes;
                this.calendarCSV = calendarCSV;
                this.step0Heading = step0Heading;
                this.step0Instructions = step0Instructions;
                this.step1Heading = step1Heading;
                this.step1Instructions = step1Instructions;
                this.step1InstructionsLoggedIn = step1InstructionsLoggedIn;
                this.step2Heading = step2Heading;
                this.step2Instructions = step2Instructions;
                this.step3Heading = step3Heading;
                this.step3Instructions = step3Instructions;
                this.step4Heading = step4Heading;
                this.step4Instructions = step4Instructions;
                this.password = password;
                this.enableSite = enableSite;
            }
        }

        /*
         * Schedule Class
         * 
         * This class contains information for the user's schedule. 
         * The 'days' list stores the CycleDay objects
         */
        class Schedule {
            userInput = [];
            days = [];

            constructor(userInput) {
                this.userInput = userInput;
                this.createDays(userInput);
            }

            getDay(cycleDayName) {
                for (var i = 0; i < this.days.length; i++) {
                    if (this.days[i].dayName == cycleDayName) {
                        return this.days[i];
                    }
                }
                return "ERROR: day not found";
            }

            //Creates each cycleday object according to the user inputs
            createDays(userInput) {
                for (var i = 0; i < userInput.length; i++) {
                    let input = userInput[i];
                    let newDay = new CycleDay(input, i);
                    this.days.push(newDay);
                }
            }

            //Creates a readable string of information in the object
            createOutputString() {
                let outputString = "";
                outputString += "User Input: " + this.userInput + "\n";
                outputString += "Days: \n";
                for (i = 0; i < this.days.length; i++) {
                    outputString += "\tDayName: " + this.days[i].dayName + "\n";
                    outputString += "\tPeriods: \n";
                    var periodsLength = this.days[i].periods.length;
                    for (j = 0; j < periodsLength; j++) {
                        var currPeriod = this.days[i].periods[j];
                        outputString += "\t\tPeriodNum: " + currPeriod.periodNum + "\n";
                        outputString += "\t\t\tClassName: " + currPeriod.className + "\n";
                        outputString += "\t\t\tFree: " + currPeriod.freePeriod + "\n";
                        outputString += "\t\t\tStart: " + currPeriod.startTime + "\n";
                        outputString += "\t\t\tEnd: " + currPeriod.endTime + "\n";
                    }
                }
                console.log(outputString);
                return outputString;
            }

        }

        /*
         * CycleDay Class
         * 
         * This class contains information for the specifc Cycle Day. 
         * The 'periods' list stores the Period objects
         */
        class CycleDay {

            dayName;
            dayNum;
            periods = [];
            userInput;

            constructor(userInput, dayNum) {
                this.userInput = userInput;
                this.createClasses(userInput);
                this.dayNum = dayNum;
                this.dayName = cycledayNames[dayNum];
            }

            //Creates each period object for the given cycle day
            createClasses(input) {
                for (var i = 0; i < input.length; i++) {
                    let periodNum = i + 1;
                    let className = input[i];
                    let newPeriod = new Period(periodNum, className);
                    newPeriod.setStartTime(periodTimes[periodNum * 2 - 2]);
                    newPeriod.setEndTime(periodTimes[periodNum * 2 - 1]);
                    this.periods.push(newPeriod);
                }
            }
        }

        /*
         * Period Class
         * 
         * This class contains information for a specifc Period. 
         * Period objects are stored within CycleDay Objects
         */
        class Period {

            periodNum;
            className;
            freePeriod;
            startTime;
            endTime;

            constructor(periodNum, userInput) {
                this.className = userInput;
                this.periodNum = periodNum;
                if (userInput == null || userInput.trim().length == 0) {
                    this.freePeriod = true;
                } else {
                    this.freePeriod = false;
                }
            }

            setStartTime(time) {
                this.startTime = time;
            }

            setEndTime(time) {
                this.endTime = time;
            }
        }
    }
}