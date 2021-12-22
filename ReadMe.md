Task:
This service get information about currency from api-service, return gif("rich" or "no money")
from other api-service, depending on the dynamics of the currency exchange rate 




Собрано с Gradle, Spring Boot, Java 11, тесты с MockBean
Упаковано с Docker

Настройки API-серверов для получения gif и курсов валют прописаны в application.properties. 
Можно изменить адреса в этом файле

**Запуск через Docker**
Открываем корневой каталог, в котором лежит Dockerfile 
через командную строку/терминал

Создаем Image, выполнив команду:

docker build -t imagerestgifapi .

где imagerestgifapi - name, которое вы можете написать любое


Создаем контейнер, выполнив команду:

docker run --name restgifapi -p 127.0.0.1:5600:5600 imagerestgifapi


Ввести в браузере http://localhost:5600/api/gif?base=USD

**Запуск через строку/терминал или IDE**

Копируем архив или клонируем код
В терминале или в IDE открываем проект
Запускаем main class RestGifApiApplication в приложении

Ввести в браузере http://localhost:5600/api/gif?base=USD


**Endpoints**

После адреса сервиса http://localhost:5600 необходимо дописать api/gif

По итогу возвращается gif в зависимости от динамики курса валют

**Parameters**
В конце адресной строки меняем параметр на нужную валюту base: string (USD).
Бесплатно можно получить только USD ((

Пример
http://localhost:5600/api/gif?base=USD

стало
http://localhost:5600/api/gif?base=EUR
