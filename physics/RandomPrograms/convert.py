import math 

ogVal = input("Pls input the number: ")
units = input("Input the unit km or m: ")
exponent = input("Input the exponent: ")

def convertToMeters(ogval):
    Mbal = float(ogVal) * 1000
    return Mbal

def convertToSci(Mval, exponent):
    bigNumber = float(Mval) * 10**int(exponent)
    return bigNumber


def convertToDif(bigNum, newExp):
    newN = bigNum/(10**float(newExp))
    return newN

if units == "km":
    Mval = convertToMeters(ogVal)
elif units == m: 
    Mval = float(ogVal)
else: 
    print("thats not a unit")

bigNum = convertToSci(Mval, exponent)
print("Your Number is ")
print(bigNum)

exitq = input("Do you wish to convert this to a diffrent power \n y or n: ")

if exitq == 'y': 
    newExp = input("Input the new exp: ")
    new = convertToDif(Mval, newExp)
    print("New value =")
    print(new)
elif exitq == 'n': 
    print("okay bye")
    exit
else: 
    print("okay bye")
    exit

