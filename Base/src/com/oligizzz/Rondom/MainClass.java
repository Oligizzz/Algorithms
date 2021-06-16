package com.oligizzz.Rondom;

import java.util.Arrays;
public class MainClass {
   public static void main(String args[]){
       VerificationRandom verification = new Verification();
       int samples = 100000;//�����ռ��С
       verification.setSamples(samples);
       //����0��mα������ĸ���:
       int m =10;
       double probability[] = verification.verificationRandom(m);
       System.out.println("�����ռ��С"+samples);
       System.out.println("����0��"+m+"α������ĸ���");
       System.out.println(Arrays.toString(probability));
       double sum = 0;
       for(double d:probability){
          sum += d;
       }
       System.out.println("���ʺ�:"+sum);
       Arrays.sort(probability);
       System.out.println("������:"+probability[probability.length-1]);
       System.out.println("��С����:"+probability[0]);
   }
} 