package com.oligizzz.Rondom;

import java.util.Random;
import java.util.HashMap;
public class Verification implements VerificationRandom {
    HashMap<String,IntegerFrequency> map;
    Random   random;
    int samples =1000;
    Verification(){
       map = new HashMap<String,IntegerFrequency>();
       random = new Random(); 
    }
    public void setSamples (int m){
       samples = m;
    }
    public double [] verificationRandom(int m){
       double probability[];//������ֳ��ֵĸ���
       probability = new double[m];
       for(int i = 0;i<samples;i++) {
          int n = random.nextInt(m);
          IntegerFrequency number = new IntegerFrequency();
          number.setNumber(n); 
          if(map.containsKey(""+n)){
             IntegerFrequency isSave = map.get(""+n);
             isSave.setCount(isSave.getCount()+1); 
          }
          else {
             map.put(""+n,number); //ɢ��ӳ����Ӽ�ֵ��
          }
       }   
       int k = 0;
       while(k<m) {
          if(map.containsKey(""+k)) {
            IntegerFrequency n = map.get(""+k);
            int count = n.getCount();
            double frequency = (double)count/samples;
            probability[k] = frequency;
          }
          k++;
       }
       return probability;
    }
    
}