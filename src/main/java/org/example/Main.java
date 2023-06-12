/* Java: знакомство и как пользоваться базовым API (семинары)
   Урок 1. Знакомство с языком программирования Java
   Первый семинар.
1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i.
2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа.
3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE и сохранить их в массив m1.
4. Найти все не кратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить их в массив m2.
Пункты реализовать в методе main

   Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  Выполнено 12.06.2023
*/
package org.example;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
        int k = 2001;
        int i = new Random().nextInt(k);        // кидалка случайных чисел
        System.out.println("1. Выпало случайное число i=" + i);

        int n = 0;
        int tmp = i;
        do {                                // делаю побитовый сбвиг вправо на 1 (или деление на 2), пока не 0
            n += 1;
            tmp = (tmp >> 1);
        } while (tmp>0);
        n -= 1;                             // минусую 1, поскольку у меня счет с 1, а нумерация битов с 0
        System.out.println("2. Номер старшего значащего бита n=" + n);

        int[] m1 = new int[Short.MAX_VALUE/n];
        int i1 = 0;
        int start = i + n - i%n;            // рассчитываю отправную точку (ближайшее сверху кратное n)
        for (int j = start; j <= Short.MAX_VALUE; j += n)   m1[i1++] = j;           // шаг = n
        System.out.printf("3. все кратные %s числа в диапазоне от %s до %s (массив m1):\n",n,i,Short.MAX_VALUE);
        for (int j = 0; j < i1; j++) {
            System.out.print(m1[j] + " ");
        }

        System.out.println();

        int[] m2 = new int[Math.abs(Short.MIN_VALUE)];
        int i2 = 0;
        for (int j = Short.MIN_VALUE; j < i; j++) {
            if (j % n != 0) {
                m2[i2] = j;
                i2++;
            }
        }
        System.out.printf("4. все НЕ кратные %s числа в диапазоне от %s до %s (массив m2):\n",n,Short.MIN_VALUE,i);
        for (int j = 0; j < i2; j++) {
            System.out.print(m2[j] + " ");
        }
        System.out.println();
    }
}