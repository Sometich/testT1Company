Для запуска проекта требуется склонировать на локальную машину и запустить через консоль при помощи команды ./gradlew bootRun либо через интерфейс IDEA
 
В проекте есть входной Rest интерфейс с url (http://localhost:8080/frequency?input={param}) который принимает строку в качестве {param} и вычисляет количество вхождений символа в него и сортирует по количеству, а затем возвращает Map в виде JSON
Пример взаимодействия:
![image](https://github.com/Sometich/testT1Company/assets/76786794/841909af-de8c-4962-accb-0ebb9283fae7)

Что отправили: http://localhost:8080/frequency?input=AaaLLLLoopfg

Что получили: 

{
    "L": 4,
    "a": 2,
    "o": 2,
    "p": 1,
    "A": 1,
    "f": 1,
    "g": 1
}

На сервис написаны 3 тест кейса:
1) Проверка status code = 200 при успешной обработке
2) Проверка, что при пустом переданном параметре, возвращается пустой массив
3) Проверка что счетчик корректно считает и сортирует ответ
![image](https://github.com/Sometich/testT1Company/assets/76786794/be5393df-d748-4b8f-8c5f-0c50f7f66f53)

 

