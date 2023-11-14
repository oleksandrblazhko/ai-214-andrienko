*ActivityScenario:* Це частина Android Testing Library і надає можливість тестувати компоненти Activity в ізоляції, спрощуючи ініціалізацію і видалення ресурсів.
*Приклад використання*
ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)

*JUnit та assertEquals:* Використовуючи метод assertEquals з JUnit, тест перевіряє, чи фактичний результат функції відповідає очікуваному. 
*Приклад використання*
assertEquals(-2, result);
