package com.pure.java;
import java.util.ArrayList;
/*
 * ********** Part 1 ************
 * You are Jake's new best friend, and he has asked you to help him visit houses that don't have insurance.
 * He has a list of houses in a neighborhood and wants to send a hologram to each house that doesn't have insurance.
 * Given a list of houses, write an algorithm that will send Jake to each qualifying house.
 */

//*********** Part 2 ************
/*
 * Part 2: Jake has learned that some houses are more likely to switch insurance companies than others.
 * Given this new information of the likelihood to switch insurance companies,
 * how can your algorithm be expanded to maximize Jake's efficiency? You also know that the insurance companies are:
 *
 * JimBobsInsuranceWarehouse, WhackyInflatableArmFlailingTubeManInsurance, and SFInsurance
 *
 * If a customer has WhackyInflatableArmFlailingTubeManInsurance
 * and has a likelihood to switch of less than 0.5, they will never switch.
 */


class JakeHologramSender_SF {
    //A populated neighborhood will be given to you
    ArrayList<House> neighborhood;

    public static void main(String[] args) {
        JakeHologramSender_SF sender = new JakeHologramSender_SF();

        sender.sendJakeHologramsToNeighborhood();

    }

    public void sendJakeHologramsToNeighborhood() {
        if(neighborhood==null || neighborhood.isEmpty()){
            System.out.println("List of homes is emtpy");
            return;
        }
        for(House house : neighborhood){//for each house send Jake if they don't have insurance
            if(!house.hasInsurance){
                if(house.insuranceCompany!=null && house.insuranceCompany.equals("WhackyInflatableArmFlailingTubeManInsurance")){
                    if(house.likelihoodToSwitch<0.5){
                        continue;
                    }
                }
            }
            sendJakeHologramToHouse(house); //send hologram to this home
        }
    }

    //This is magic done by the post office
    public void sendJakeHologramToHouse(House house) {}
}

class House {
    boolean hasInsurance;

    //Part Two
    String insuranceCompany;
    double likelihoodToSwitch;

}
