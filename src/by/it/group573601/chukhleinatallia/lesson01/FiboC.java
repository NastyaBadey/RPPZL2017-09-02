package by.it.group573601.chukhleinatallia.lesson01;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

import java.util.ArrayList;

public class FiboC {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        FiboC fibo = new FiboC();
        int n = 10;
        int m = 2;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }


    long fasterC(long n, int m) {
        //решение практически невозможно найти интуитивно
        //вам потребуется дополнительный поиск информации
        //см. период Пизано-дина периода этой последовательности
        long array[]=new long[6*m];//6*м макс размер который может быть у пер.
        array[0]=0;
        array[1]=1;
        int i=2;//начинаем с 3эл
        long p=1;
        do{ array[i]=(array[i-1]+array[i-2])%m;//находится остаток отделения числа фибон. и заносим в массив
        p++;
        if (array[i]==1&&array[i-1]==0)//когда в массиве какое-то усвие облюдается то прерываемся и идем в цикл
        { break;}
        i++;}
        while (i<n);
        int val=(int)(n%p);//находи индекс - остаток от деления
        return array[val];
    }


}

