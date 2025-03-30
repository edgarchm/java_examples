package com.pure.java;
import java.util.ArrayList;
/*
 * ********** Part 1 ************
 * A friend has asked you to help him visit houses that don't have insurance.
 * He gave you list of houses and wants to send a letter to each house that doesn't have insurance.
 * Given a list of houses, write a code that will send email to homes that qualify.
 */

//*********** Part 2 ************
/*
 * Part 2: Some homes are more likely to switch insurance companies than others.
 * Given this, how can your algorithm be expanded to maximize efficiency?
 * There are other insurance companies:
 *
 * OtherInsurer1(OI1), OtherInsurer2 (OI2), and YourFriendInsurance(YFI)
 *
 * If a customer has OtherInsurer2
 * and has a likelihood to switch of less than 0.3, they will not switch.
 */


class InsuranceEmail {
    //A populated neighborhood will be given to you
    ArrayList<House> homes_array;

    public static void main(String[] args) {
        InsuranceEmail sender = new InsuranceEmail();

        sender.emailSender();

    }

    public void emailSender() {
        if(homes_array ==null || homes_array.isEmpty()){
            System.out.println("List of homes is empty");
            return;
        }
        for(House house : homes_array){//for each house send email if they don't have insurance
            if(!house.isInsured){
                if(house.insurerName !=null && house.insurerName.equals("OtherInsurer2")){ //OI2
                    if(house.wouldSwitch <0.3){
                        continue;
                    }
                }
            }
            sendEmailToClients(house); //send email to this home even when insured by OI1 and YFI
        }
    }

    //This is magic done by the post office
    public void sendEmailToClients(House house) {}
}

class House {
    boolean isInsured;

    //Part Two
    String insurerName;
    double wouldSwitch;

}
