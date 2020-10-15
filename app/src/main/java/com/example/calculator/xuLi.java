package com.example.calculator;

import android.util.Log;
import android.widget.TextView;

public class xuLi {
    private int t = 1, c1 = 0, c2 = 0;
    private boolean d1 = false, d2 = false;
    private StringBuilder s1, s2;
    private char z = '\0';

    public xuLi() {
        s1 = new StringBuilder();
        s2 = new StringBuilder();
        s1.append('0');
    }

    public void appendN(int n, TextView mytextview) {
        switch (t) {
            case 1:
                s1.deleteCharAt(0);
                s1.append(n);
                t=2;
                this.print(mytextview);
                break;
            case 2:
                s1.append(n);
                print(mytextview);
                break;
            case 3:
                s2.append(n);
                t = 5;
                print(mytextview);
                break;
            case 4:
                s2.deleteCharAt(0);
                s2.append(n);
                t = 5;
                print(mytextview);
                break;
            case 5:
                s2.append(n);
                print(mytextview);
                break;
        }
    }

    public void appendZero(TextView mytextview) {
        switch (t) {
            case 1:
                break;
            case 2:
                s1.append('0');
                print(mytextview);
                break;
            case 3:
                s2.append('0');
                t = 4;
                print(mytextview);
                break;
            case 4:
                break;
            case 5:
                s2.append(0);
                print(mytextview);
                break;
        }
    }

    private void print(TextView mytextview) {
        switch (this.t) {
            case 1:
                mytextview.setText("0");
                break;
            case 2:
                String s = s1.substring(0);
                mytextview.setText( ((this.d1 == false)? "" : "-") +  s1.substring(0));
                break;
            case 3:
                mytextview.setText(((this.d1 == false) ? "" : "-") + this.s1.substring(0));
                break;
            case 4:
                mytextview.setText(((this.d2 == false) ? "" : "-") + this.s2.substring(0));
                break;
            case 5:
                mytextview.setText(((this.d2 == false) ? "" : "-") + this.s2.substring(0));
                break;
        }
    }

    public void appendDau(char z, TextView mytextview) {
        switch (t) {
            case 1:
                this.z = z;
                t = 3;
                break;
            case 2:
                this.z = z;
                t = 3;
                break;
            case 3:
                this.z = z;
                break;
            case 4:
                float tmp2 = ((d1 == false) ? 1 : -1) * Float.parseFloat(s1.substring(0));
                float tmp3 = AandB(tmp2,0);
                if(tmp3<0) d1=true;
                else d1=false;
                c1 = 1;
                s1.delete(0,s1.length());
                s2.delete(0,s2.length());
                t=3;
                s1.append(Float.toString((((d1 == false) ? 1 : -1)*tmp3)));

                this.z = z;
                print(mytextview);
                break;
            case 5:
                float tmp4 = ((d1 == false) ? 1 : -1) * Float.parseFloat(s1.substring(0));
                float tmp5 = ((d2 == false) ? 1 : -1) * Float.parseFloat(s2.substring(0));
                float tmp6 = AandB(tmp4,tmp5);
                if(tmp6<0) d1=true;
                else d1=false;
                c1 = 1;
                s1.delete(0,s1.length());
                s1.append(Float.toString((((d1 == false) ? 1 : -1)*tmp6)));
                s2.delete(0,s2.length());c2=0;d2=false;
                t=3;
                this.z = z;
                print(mytextview);
                break;
        }
    }

    private float AandB(float a, float b) {
        float c = 0;
        switch (z) {
            case '+':
                c = a + b;
                break;
            case '-':
                c = a - b;
                break;
            case '*':
                c = a * b;
                break;
            case '/':
                c = a / b;
                break;
        }
        return c;
    }
    public void DoiSo(TextView mytextview){
        switch (t) {
            case 1:
                break;
            case 2:
                if(d1) d1=false;
                else d1 = true;
                print(mytextview);
                break;
            case 3:
                float tmp = (Float.parseFloat(s1.substring(0)));
                if(tmp==0){
                    if(c1==0) {
                        t = 4;
                        s2.append(s1.substring(0));
                    }else{
                        t=5;c2=c1;s2.append(s1.substring(0));
                    }
                }else{
                    s2.append(s1.substring(0));
                    d2=d1;c2=c1;
                    t=5;
                    if(d2) d2=false;
                    else d2 = true;
                    print(mytextview);
                }
                break;
            case 4:
                break;
            case 5:
                if(d2) d2=false;
                else d2 = true;
                print(mytextview);
                break;
        }
    }
    public void cham(TextView mytextview){
        switch (this.t) {
            case 1:
                s1.append('.');
                t=2;c1=1;
                print(mytextview);
                break;
            case 2:
                if(c1==1)break;
                s1.append('.');
                c1=1;
                print(mytextview);
                break;
            case 3:
                s2.append(s1.substring(0));
                d2=d1;c2=c1;
                t=5;
                print(mytextview);
                break;
            case 4:
                s2.append('.');
                t=5;c2=1;
                print(mytextview);
                break;
            case 5:
                if(c2==1)break;
                s2.append('.');
                c2=1;
                print(mytextview);
                break;
        }
    }
    public void bang(TextView mytextview){
        switch (t) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                float tmp = ((d1 == false) ? 1 : -1) * Float.parseFloat(s1.substring(0));
                float tmp1 = AandB(tmp,tmp);
                if(tmp1<0) d1=true;
                else d1=false;
                c1 = 1;
                s1.delete(0,s1.length());
                s1.append(Float.toString((((d1 == false) ? 1 : -1)*tmp1)));
                t=2;
                print(mytextview);
                z='\0';
                break;
            case 4:
                float tmp2 = ((d1 == false) ? 1 : -1) * Float.parseFloat(s1.substring(0));
                float tmp3 = AandB(tmp2,0);
                if(tmp3<0) d1=true;
                else d1=false;
                c1 = 1;
                s1.delete(0,s1.length());
                s1.append(Float.toString((((d1 == false) ? 1 : -1)*tmp3)));
                s2.delete(0,s2.length());
                t=2;
                print(mytextview);
                break;
            case 5:
                float tmp4 = ((d1 == false) ? 1 : -1) * Float.parseFloat(s1.substring(0));
                float tmp5 = ((d2 == false) ? 1 : -1) * Float.parseFloat(s2.substring(0));
                float tmp6 = AandB(tmp4,tmp5);
                if(tmp6<0) d1=true;
                else d1=false;
                c1 = 1;
                s1.delete(0,s1.length());
                s1.append(Float.toString((((d1 == false) ? 1 : -1)*tmp6)));
                s2.delete(0,s2.length());d2=false;
                t=2;
                print(mytextview);
                break;
        }
    }
    public void ce(TextView mytextview){
        switch (this.t) {
            case 1:
                break;
            case 2:
                s1.delete(0,s1.length());
                s1.append('0');
                d1=false;c1=0;t=1;
                print(mytextview);
                break;
            case 3:
                t=4;
                s2.append('0');
                print(mytextview);
                break;
            case 4:
                break;
            case 5:
                s2.delete(0,s2.length());
                t=4;d2=false;c2=0;
                s2.append('0');
                print(mytextview);
                break;
        }
    }
    public void c(TextView mytextview){
        switch (this.t) {
            case 1:
                break;
            case 2:
                s1.delete(0,s1.length());
                s1.append('0');
                d1=false;c1=0;t=1;
                print(mytextview);
                break;
            case 3:
                s1.delete(0,s1.length());
                s1.append('0');
                d1=false;c1=0;t=1;
                z='\0';
                print(mytextview);
                break;
            case 4:
                s1.delete(0,s1.length());
                s1.append('0');
                d1=false;c1=0;t=1;
                z='\0';
                s2.deleteCharAt(0);
                print(mytextview);
                break;
            case 5:
                s2.delete(0,s2.length());
                s1.delete(0,s1.length());
                s1.append('0');
                d1=false;c1=0;t=1;
                d2=false;c2=0;
                z='\0';
                print(mytextview);
                break;
        }
    }
    public void bs(TextView mytextview){
        switch (this.t) {
            case 1:
                break;
            case 2:
                if(s1.length()>2){
                    if(s1.charAt(s1.length()-1)=='.'){
                        s1.deleteCharAt(s1.length()-1);
                        c1=0;
                    }else{
                        s1.deleteCharAt(s1.length()-1);
                    }
                }else{
                    if(s1.length()==2){
                        if(s1.substring(0)=="0."){
                            s1.deleteCharAt(1);
                            t=1;c1=0;d1=false;
                        }else {
                            if (s1.charAt(1) == '.') {
                                s1.deleteCharAt(1);
                                c1 = 0;
                            } else s1.deleteCharAt(1);
                        }
                    }else{
                        d1=false;s1.deleteCharAt(0);s1.append('0');t=1;
                    }
                }
                print(mytextview);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                if(s2.length()>2){
                    if(s2.charAt(s2.length()-1)=='.'){
                        s2.deleteCharAt(s2.length());
                        c2=0;
                    }else{
                        s2.deleteCharAt(s2.length());
                    }
                }else{
                    if(s2.length()==2){
                        if(s2.substring(0)=="0."){
                            s2.deleteCharAt(1);
                            t=4;c2=0;d2=false;
                        }else {
                            if (s2.charAt(1) == '.') {
                                s2.deleteCharAt(1);
                                c2 = 0;
                            } else s2.deleteCharAt(1);
                        }
                    }else{
                        d2=false;s2.deleteCharAt(0);s2.append('0');t=4;
                    }
                }
                print(mytextview);
                break;
        }
    }

}