#language: ru

@test
Функционал: Вход в систему Gmail
  Описываем вход в систему (позитивный и негативный).
  Сценарий: Вход в систему позитивный, проверка выхода из учетной записи и вход в систему негативный.
    Пусть открыта страница входа в приложение 'https://mail.google.com/mail/'
    И пользователь вводит в поле "имя пользователя" значение "plmailtestsel"
    И нажимает кнопку "далее (пользователь)"
    И пользователь вводит в поле "пароль" значение "plgmail123Test"
    И нажимает кнопку "далее (пароль)"
    Тогда открылась главная страница
    И нажимает кнопку "аккаунт google"
    #Кнопка находится в правом верхнем углу.
    Тогда в появившемся виджете видно почту пользователя "plmailtestsel@gmail.com"
    #Пользователь решает написать
    И нажимает кнопку "черновики"
    И нажимает кнопку "Написать"
    И видит, что появился виджет "Новое сообщение"
    И пользователь вводит в поле "кому" значение "mozhg@mail.ru"
    И пользователь вводит в поле "тема" значение "draft check"
    И пользователь вводит в поле "тело письма" значение "draft check draft check draft check"
    И нажимает кнопку "сохранить и закрыть"
    Тогда пользователь выбирает "последний черновик"
    И видит в поле "кому" значение "mozhg@mail.ru"
    И видит в поле "тема" значение "draft check"
    И видит в поле "тело письма" значение "draft check draft check draft check"
    И нажимает кнопку "отправить"
    И нажимает кнопку "отправленные"
    И видит в поле "кому отправленного письма" значение "mozhg"
    И видит в поле "тема" значение "draft check"
    И видит в поле "тело отправленного письма" значение "draft check draft check draft check"
    Пусть пользователь выходит из учетной записи
    Пусть открыта страница входа в приложение 'https://mail.google.com/mail/'
    #Проверка выхода из учетной записи и вход в систему негативный.
    И пользователь вводит в поле "пароль" значение "wrong_pass"
    И нажимает кнопку "далее (пароль)"
    Тогда появилось сообщение о неуспешном входе "Неверный пароль. Повторите попытку или нажмите на ссылку "Забыли пароль?", чтобы сбросить его."