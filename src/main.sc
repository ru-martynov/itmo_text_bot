require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.
        
    state: Weather
        q!: $regex</weather>
        a: Запрос прогноза погоды, какая у Вас сейчас?
        buttons:
            "солнце" -> /RequestWeather
            "облачно" -> /RequestWeather
            "снег" -> /RequestWeather
            "дождь" -> /RequestWeather
            
    state: Help
        q!: $regex</help>
        a: Имеющиеся команды: /start, /weather, /currency

    state: RequestWeather
        a: Сейчас на улице {{$request.query}} 
        
    state: Currency
        q!: $regex</currency>
        a: Какой курс доллара?
        
        state:
            q!: *
            a: Курс доллара {{$request.query}}!
            

    state: Hello
        intent!: /привет
        a: Привет привет

    state: Bye
        intent!: /пока
        a: Пока пока

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}
