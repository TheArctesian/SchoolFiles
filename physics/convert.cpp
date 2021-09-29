#include <iostream>
#include <math.h>
#include <cmath>

using namespace std;

float toM(string units, int inputLength){
    float toMeters;
    if (units == "km") {
        toMeters = inputLength*1000;
    }
    else if (units == "m"){
        toMeters = inputLength;
    }
    else{
        cout << "Error in input" << endl;
	return -1;
    }

    return toMeters; 
}
int converted(float convertedToMeters, int expontent){
    int sciExpo = pow(10, expontent);
    int number = convertedToMeters * sciExpo;
    
    return number;
}

int main(){
    float inputLength;
    cout << "Input a distance: ";
    cin >> inputLength;

    string units;
    cout << "is it in meters or km \nm/km: ";
    cin >> units;

    int expontent;
    cout << "Add What power of 10 your is to: ";
    cin >> expontent;
    
    float convertVal;
    int convertedToMeters; 
    convertedToMeters = toM(units, inputLength);

    convertVal = converted(convertedToMeters, expontent);
    string convertValSci = convertedToMeters + "x 10^" + expontent; 

    cout << "Your length is ";
    cout << convertVal << endl;
    cout << "\n or " << convertedToMeters << "x + 10^" << expontent << endl;
    return 0;
}