#pragma config(Sensor, in1,    rightSensor,    sensorLineFollower)
#pragma config(Sensor, in2,    leftSensor,     sensorLineFollower)
#pragma config(Sensor, dgtl1,  killSwitch,     sensorDigitalIn)
#pragma config(Sensor, dgtl3,  bumper1,        sensorDigitalIn)
#pragma config(Sensor, dgtl5,  bumper2,        sensorDigitalIn)
#pragma config(Sensor, dgtl7,  bumper3,        sensorTouch)
#pragma config(Sensor, dgtl9,  bumper4,        sensorTouch)
#pragma config(Sensor, dgtl10, bumper5,        sensorTouch)
#pragma config(Motor,  port1,           rightMotor,    tmotorVex393_HBridge, openLoop)
#pragma config(Motor,  port10,          leftMotor,     tmotorVex393_HBridge, openLoop, reversed)
//*!!Code automatically generated by 'ROBOTC' configuration wizard               !!*//

// Ex6 - Track a straight line

int Power = 60;    //initialise variable

void moveback right()

{
          motor[leftMotor]  = -power;
          motor[rightMotor] = -power;
          wait1Msec(1000);
          motor[leftmotor] = 0;
          motor[rightmotor] = -power;
          wait1Msec(1000)

}


void moveback left()

{
          motor[leftMotor]  = -power;
          motor[rightMotor] = -power;
          wait1Msec(1000);
          motor[leftmotor] = -power;
          motor[rightmotor] = 0;
          wait1Msec(1000)

}


task checkKill()    //check if kill switch has been pressed
{
    waitUntil(SensorValue(killSwitch) == 0);

    stopAllMotors();
    stopAllTasks();
}


task main()
{
    int threshold = 2300;

    // start the kill task
    startTask(checkKill);

    while(true)
    {
      if(SensorValue(leftSensor) > threshold)
      {
          // left sees black, turn left
          motor[leftMotor]  = Power * -1;
          motor[rightMotor] = Power;
          wait1Msec(500);
      }
      else if(SensorValue(rightSensor) > threshold)
      {
          // right sees black, turn right
          motor[leftMotor]  = Power;
          motor[rightMotor] = (Power*-1);
          wait1Msec(500);
      }
      else
      {
          // move forward
          motor[leftMotor]  = Power;
          motor[rightMotor] = (Power-10);
      }


        {
            if(SensorValue(bumper1) == 1)
                moveback right();
        }

        {
            if(SensorValue(bumper2) == 1)
                moveback right();
        }

        {
            if(SensorValue(bumper3) == 1)
                moveback right();
        }

        {
            if(SensorValue(bumper4) == 1)
                moveback left();
        }

        {
            if(SensorValue(bumper5) == 1)
                moveback left();
        }


            }