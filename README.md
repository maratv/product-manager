# Список продуктов

### Сервис с использованием Spring Boot, MongoDB, Swagger.

Сервис содержит несколько API endpoint’ов. Формат запроса и ответа - json.

## Объекты
### - Product
* long : id
* String : name
* String : description
* int : kcal

### - List
* long : id
* String : name

## Связи
List может быть любое количество Product.

### Сохранение
По API доступно:
* Product
* List
* добавлять Product в созданный List

### Получение
API должно давать возможность получать списки:
* Product
* List со всеми Product, которые относятся к данному List по id
