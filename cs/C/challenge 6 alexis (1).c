#pragma config(Sensor, in2,    Rightline,      sensorLineFollower)
#pragma config(Sensor, in3,    centerline,     sensorLineFollower)
#pragma config(Sensor, in4,    Leftline,       sensorLineFollower)
#pragma config(Sensor, dgtl1,  bump,           sensorTouch)
#pragma config(Motor,  port1,           Rightmotor,    tmotorVex393_HBridge, openLoop)
#pragma config(Motor,  port10,          Leftmotor,     tmotorVex393_HBridge, openLoop, reversed)
//*!!Code automatically generated by 'ROBOTC' configuration wizard               !!*//

void gostraight()
{
    motor (Leftmotor) = 50;
    motor (Rightmotor) = 50;
    wait1Msec(100);

}

void turnLeft()
{
   motor (Leftmotor) = -50;
   motor(Rightmotor) = 50;
   wait1Msec(100);
}

void turnRight()
{
    motor(Leftmotor) = 50;
    motor(Rightmotor) = -50;
    wait1Msec(100);
}



task main()
{
    while (true)
    {


        if(SensorValue[Leftline] > 2600 && SensorValue [centerline] < 2600 && SensorValue [Rightline] < 2600)
        {
            turnLeft();
            wait1Msec(100);

        }

        if(SensorValue[centerline] > 2600 && SensorValue[Rightline] < 2600 && SensorValue [Leftline] < 2600)

            gostraight();
            wait1Msec(100)

            if(SensorValue[Rightline] > 2600 && SensorValue [Leftline] < 2600 && SensorValue [centerline] < 260)
            {
                turnRight();
                wait1Msec(100);
            }
        }





}
