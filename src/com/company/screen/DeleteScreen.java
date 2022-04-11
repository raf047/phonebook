package com.company.screen;

public class DeleteScreen extends Screen{

    @Override
    public void process() {
//        while (true){
//            String i = getStringFromUser();
//            if (i.equals("1")){
//                DeleteByNameScreen deleteByNameScreen = new DeleteByNameScreen();
//                deleteByNameScreen.process();
//                break;
//            } else if (i.equals("2")){
//                DeleteByPhoneNumberScreen deleteByPhoneNumberScreen = new DeleteByPhoneNumberScreen();
//                deleteByPhoneNumberScreen.process();
//                break;
//            }else {
//                System.out.println("Wrong input! Please enter valid number");
//            }
//        }
        System.out.println("Delete");
        DeleteByNameScreen deleteByNameScreen = new DeleteByNameScreen();
        deleteByNameScreen.process();
    }
}
