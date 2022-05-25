// use std::collections::HashMap;  could use this for storing or could just print
fn main() {
    // new array with size of 5
    // array = [x, 3, 3, y, z] 
    // since we medium is 3 then medium number will always be 3 
    // since mode is 3 mode has to come up at lease once 
    println!("Running");
    // create array of arrays 
    let mut outputs = [[0; 3]; 100];
    let k = 100;
    let i = 0;
    let place = 0;
    let mut array : [i32; 3] = [x, 0, 0];
    while i > k {
        x = array[i];
        let avgVal = avg(array);
        let check_array = check_array(array);
        if avgVal == 5 && check_array == true {
            pOut(array);
        }
        else{
            i+=1;
        }
    }
    let i = 0;
    let mut array : [i32; 3] = [0, x, 0];
    while i > k {
        x = array[i];
        let avgVal = avg(x, array);
        let check_array = array;
        if avgVal == 5{
            pOut(array);
        }
        else{
            i+=1;
        }
    }
    let i = 0;
    let mut array : [i32; 3] = [0, 0, x];
    while i > k {
        x = array[i];
        let avgVal = avg(x, array);
        let check_array = array;
        if avgVal == 5{
            pOut(array);
        }
        else{
            i+=1;
        }
    }

}

fn pOut(array : [i32; 3]) {
    let far : [i32; 5] = []; 
    far.put(array(1));
    fat.put(3);
    fat.put(3);
    far.put(array(2));
    far.put(array(3));
    far.put(outputs[i][0]);
    println!("{:?}", far);
}


//function to calculate the avg of an array
fn avg(array: &[i32]) -> f32 {
    let mut sum = 0;
    for i in array {
        sum += i;
    }
    sum +=6; //for adding the two 3s 
    sum as f32 / 5 as f32
}


fn check_array(array: &[i32]) -> bool {
    let mut num1 = &array[0]; 
    // number two is the first item of the array
    let mut num2 = &array[1];
    // number three is the second item of the array
    let mut num3 = &array[2];
    // check if num1 is equal to num2 or num2 is equal to num3 or num3 is equal to num1
    if num1 == num2 || num2 == num3 || num3 == num1 {
        return false
    }
    else{
        return true
    }
}