/*Silly attemt at a name generator
*
*
I'm an author, and I wanted to make a tool 
to help create fictional names. 

This program works by randomly selecting a combination 
of Vowels and Consonants for a random length. 
Then, my code makes sure that there can only be two 
of each letter type sequentially.
This way, instead of just producing letter soup 
all names generted are at least pronouncable (in theory). 

Though I can't promise that even most names may
even be to your taste, by logic, this can produce 
all possible names (between 3-8 characters). 
So, if you're open to any names, then hopefully, 
this tool will eventually help you find one.

Feel free to pass it on to any who may need it.
Thanks!
*
*
*/

import java.util.*;

public class Name
{
    public static void main(String[] args) {
        System.out.print("By Wesley Lancaster 12/12/23\n\n");
        Name N = new Name();

        String NormalType = "made with normal engligh letters";
        String NormalV[] = {"a", "e", "i", "o", "u"};
        String NormalC[] = {
                "b", "c", "d", "f", "g", "h",
                "j", "k", "l", "m", "n",
                "p", "q", "r", "s", "t",
                "v", "w", "x", "y", "z"};

        String typeGoogle = "Made From Google Pronouncination API Tool Thingy.";
        String GoogleV[] = {
                "a-", "ei-", "ehr-", "aa-", "aar-", "eh-",
                "ee-", "eer-", "i-", "ai-", "aa-", "ow-",
                "aa-", "or-", "awr-", "oy-", "u-", "oor-",
                "oo-", "awa-", "uh-", "ur-", "r-", "yooh-",
                "ha-", "rr-", "pa-", "taa-", "pee-", "ree-",
                "see-", "gee-", "ww-", "poo-", "too-", "foo-",
                "roo-", "woo-", "goo-", "koo-", "moo-", "pe-",
                "fo-", "go-", "ro-",  "zo-", "na-", "no-",
                "ba-", "bo-", "bi-", "ni-", "bu"};
        String GoogleC[] = {
                "ch-", "g-", "h-", "hw-", "j-", "k-",
                "kh-", "ng-", "s-", "sh-", "th-", "y-",
                "zh-", "dh-", "xi-", "t-", "qe-", "ve-",
                "te-", "beh-", "ol-", "mm-", "p-", "el-",
                "d-", "zz-", "b-", "d-", "f-", "l-",
                "m-", "n-", "p-", "d-", "t-", "v-",
                "w-", "z-", "oz"};

        String typeWesley = "Made With Wesley Name.";
        String WesleyVowels[] = {"e"};
        String WesleyConsonants[] = {"l", "s", "w", "y"};

        N.NameTheBaby(NormalV, NormalC, NormalType);
        //N.NameTheBaby(GoogleV, GoogleC, typeGoogle);
        //N.NameTheBaby(WesleyVowels, WesleyConsonants, typeWesley);
    }

    private void NameTheBaby(String[] Vowels, String[] Consonants, String typeName){

        Random rand = new Random();

        System.out.println("\n---" + Vowels.length * Consonants.length * (8*7*6*5*4*3)
                + " Random names " + typeName + "---\n");

        //this for loop tells us how many names we want to print, in this case, 5.
        for(int j = 0; j < 10; j++){

            //here we determine the length of the word randomly. ~ no more than 8 letters, no less than 3
            int length = rand.nextInt(5) + 3;
            //these will be used to keep track of sequence of Vowels and Consonants.
            int c = 0;
            int v = 0;
            //now, we loop through the length of the word, which was randomly generated.
            for(int i =0; i < length; i++){
                //this 'type' is respondiple for randomly selecting letters.
                int type = rand.nextInt(3 - 1) + 1;
                //this switch ensures no more than two sequential Vowels or Consonants 
                switch(type){
                    case 1:
                        if(v >= 1){
                            System.out.print(Consonants[rand.nextInt(Consonants.length)]);
                            c++;
                            v = 0;
                            break;
                        }
                        else{
                            System.out.print(Vowels[rand.nextInt(Vowels.length)]);
                            v++;
                            break;
                        }
                    case 2:
                        if(c >= 1){
                            System.out.print(Vowels[rand.nextInt(Vowels.length)]);
                            c = 0;
                            v++;
                            break;
                        }
                        else{
                            System.out.print(Consonants[rand.nextInt(Consonants.length)]);
                            c++;
                            break;
                        }
                }
            }
            System.out.println("\n");
        }
    }
}