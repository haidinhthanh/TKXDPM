/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValidateInput;

/**
 *
 * @author haidt
 */
public class ValidateInput {
    public static boolean checkNumber(String number){
            try {
                Integer num=Integer.parseInt(number);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
}
