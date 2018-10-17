package com.sx.array.stringCutToArrays;

/**
 * 将字符串内容按照固定格式拆开依次保存到person对象中,再将person对象保存到persons数组中
 */
public class stringCutToArrays {

    public static void main(String[] args) {

        String text = "jhon,18,男;green,20,女;jack,19,男;liming,25,男";
        //根据字符分割
        String[] textArrays = text.split("[,;]");

        //遍历字符串,将内容依次保存到person对象中,再将person对象保存到persons数组中
        Person[] persons = new Person[10];
        for (int i = 0; i < textArrays.length; i+=3) {
            Person person = new Person();

            person.setName(textArrays[i]);
            person.setAge(textArrays[i+1]);
            person.setGender(textArrays[i+2]);

            persons[i/3] = person;
        }

        //遍历persons数组
        for (Person person: persons) {
            if (persons != null){
                System.out.println(person);
            }
        }
    }
}
