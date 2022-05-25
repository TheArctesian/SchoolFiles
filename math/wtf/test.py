class cout:
    HEADER = '\033[95m'
    OKBLUE = '\033[94m'
    OKCYAN = '\033[96m'
    OKGREEN = '\033[92m'
    WARNING = '\033[93m'
    FAIL = '\033[91m'
    ENDC = '\033[0m'
    BOLD = '\033[1m'
    UNDERLINE = '\033[4m'

def calculateMean(array):
    return sum(array) / len(array)

def checkDuplicate(array):
    x = array[0]
    y = array[1]
    z = array[2]
    print("checkDuplicate: ", x, y, z)
    if x == y or x == z or y == z:
        return True
    else:
        print(cout.OKBLUE + "false" + cout.ENDC)
        return False
    

array = [0,0,0]
if checkDuplicate(array): 
    print("Duplicate")
else:
    print(cout.OKGREEN + "Not duplicate" + cout.ENDC)




x = 0
output = [0, 3, 3, 0, 0]
while x < 100:
    output[0] += x
    print(output)
    mean = calculateMean(output)
    if mean != 5:
        x+1
    elif mean == 5:
        x+1
        print(cout.OKGREEN + "One combanationn is" + output + cout.ENDC)   

print(cout.OKGREEN + "Done" + cout.ENDC)