from PIL import Image
from os import listdir
from os.path import isfile, join

def returnFilesInDir(path):
    files = [f for f in listdir(path) if isfile(join(path, f))]
    return files


def convertHEICtoPNG(file):
    #write this function 
    convertedFile = ''
    return convertedFile

def testFile(testFile):
    try:
        imageObj = Image.open(testFile)
        imageObj.show()
        fliped = imageObj.transpose(Image.ROTATE_90)
        imageObj.show()
        # some write function
    except:
        print("Unable to open file. Check input string or IMG format")


if __name__ == '__main__':
    dir = ['./Iron men/', './3 Level Story/']
    testFile('./P4-5.HEIC')
    # test if can open pros img fmt
    for i in dir:
        files = returnFilesInDir(i)
        for x in files:
            pngFile = convertHEICtoPNG(x)
            imgObj = Image.open(pngFile)
            fliped = imgObj.transpose(Image.ROTATE_90)
            # some write function for output
            # fliper.write(i)

