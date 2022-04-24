package ru.fivep.app.screens.recommendation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@ExperimentalMaterial3Api
@Composable
fun RecommendationScreen(
    navController: NavController,
    text: String
) {
    var size by remember { mutableStateOf(14.sp) }


    Scaffold(
        topBar = {
             CenterAlignedTopAppBar(
                 title = {
                     Row {
                         Icon(
                             imageVector = Icons.Default.CollectionsBookmark,
                             contentDescription = null
                         )
                         Spacer(modifier = Modifier.size(4.dp))
                         Text(text = "Рекомендация")
                     }
                 },
                 navigationIcon = {
                     IconButton(onClick = { navController.navigateUp() }) {
                         Icon(
                             imageVector = Icons.Default.ArrowBack,
                             contentDescription = "Назад"
                         )
                     }
                 },
                 actions = {
                     IconButton(
                         onClick = { size = (size.value - 1).sp },
                         enabled = size.value > 10
                     ) {
                         Icon(
                             imageVector = Icons.Default.ZoomOut,
                             contentDescription = "Уменьшить"
                         )
                     }
                     IconButton(
                         onClick = { size = (size.value + 1).sp },
                         enabled = size.value < 35
                     ) {
                         Icon(
                             imageVector = Icons.Default.ZoomIn,
                             contentDescription = "Увеличить"
                         )
                     }
                 }
             )
        },
        content = {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    Text(
                        modifier = Modifier
                            .fillMaxSize().padding(5.dp),
                        text = text,
                        fontSize = size
                    )
                }
            }
        }
    )
}

object RecommendationText {
    const val RECOMMENDATION_MAIN = "Основной принцип построения проекта по формуле 5 «П»:\n" +
            "\n" +
            "1. ПРОБЛЕМА\n" +
            "Проблема - это некая противоречивая ситуация, возникшая в результате работы, определившая тему исследования и требующая своего разрешения в итоге исследовательской работы. Проблема определяет тактику и стратегию работы.\n" +
            "Из формулировки темы должно быть понятно, что не так, почему не так и что будет, если сделать как надо.\n" +
            "\n" +
            "Каким требованиям должна удовлетворять проблема? Проблема должна быть важной, интересной. При решении проблемы должны быть использованы имеющиеся знания, исследовательские методы.\n" +
            "\n" +
            "2. ПРОЕКТИРОВАНИЕ\n" +
            "Этап проектирования распадается на две составляющих:  подготовительный этап и планирование.\n" +
            "\n" +
            "На подготовительном этапе необходимо:\n" +
            " — Сформулировать тему проекта в соответствии с проблемой\n" +
            " — Определить цели проекта\n" +
            " — Обозначить конечный продукт (презентация, стенгазета, буклет и т. д.)\n" +
            " — Выбрать тип проекта (например: исследовательский, практико-ориентированный, ролевой, игровой, творческий, информационный)\n" +
            " — Назначить сроки выполнения проекта и соблюдать их\n" +
            "\n" +
            "Наводящие вопросы:\n" +
            " — Проблема проекта — Почему?\n" +
            " — Цель проекта — Зачем мы это делаем?\n" +
            " — Задачи — Что мы делаем?\n" +
            " — Методы и способы — Как мы делаем?\n" +
            " — Оценка имеющихся и недостающих ресурсов — Что уже есть в арсенале для выполнения проекта, а чего не хватает?\n" +
            " — Сроки выполнения — Когда мы делаем?\n" +
            " — Конечный продукт — В каком виде будем презентовать результат своего труда?\n" +
            "\n" +
            "3. ПОИСК (ИНФОРМАЦИИ)\n" +
            "Этот этап работы называется этапом реализации проекта. В это момент происходит непосредственный поиск информации в различных источниках.\n" +
            "\n" +
            "Способы сбора информации\n" +
            " — Наблюдение\n" +
            " — Анкетирование\n" +
            " — Социологический опрос\n" +
            " — Проведение экспериментов\n" +
            "\n" +
            "Принципы отбора информации:\n" +
            " — Принцип наглядности: информация доступна для восприятия и понимания, формируемые информацией образы достоверны, основные понятия, объекты и явления могут быть продемонстрированы, информация соответствует запрашиваемым критериям\n" +
            "\n" +
            " — Принцип научности: данные соответствуют научным представлениям современности, ошибки и неточности не способны повлечь за собой искажения объективной картины, касающейся вопроса\n" +
            "Информация может иметь вид исторического документа, который показывает путь развития конкретного научного знания\n" +
            "\n" +
            " — Принцип актуальности: информация должна быть практичной, соответствующей современным запросам, важной на текущий момент времени. Такая информация способна вызвать наибольший интерес, \n" +
            "в отличие от неактуальной. Желательно, чтобы информация была близка по времени и волновала исследователя, должна обладать исторической ценностью или быть важной по иным причинам.\n" +
            "\n" +
            " — Принцип систематичности: аналогичные данные можно найти в различных базах данных, различные интерпретации не разрушают целостность представлений об одной и той же проблеме\n" +
            "\n" +
            " — Принцип доступности: информация должна быть не только доступной для понимания с точки зрения терминологии, она будет восприниматься интересной, но не банальной, должна предполагать и дидактическую обработку, которая снимает терминологический барьер (адаптировать под себя, при этом сохранив смысл)\n" +
            "\n" +
            " — Принцип избыточности: исследуемая информация должна позволять исследователю выделять основную мысль, находить скрытый смысл, если таковой имеется, приходить к пониманию авторской позиции, определять цели изложения и развивать умение соотносить содержание с назначением.\n" +
            "\n" +
            "4. ПРОДУКТ\n" +
            "Продуктом труда является запланированный результат. Причём продукты одного и того же проекта могут быть различны.\n" +
            "Например: эмблема, газета, альбом, мультимедийный продукт (видеофильм, видеоролик или веб-сайт), мероприятием (экскурсия, математический вечер, викторина, праздник)\n" +
            "\n" +
            "5. ПРЕЗЕНТАЦИЯ\n" +
            "Вне зависимости от уровня материала именно способность заинтересовать слушателей. Подходите к представлению проекта творчески, чтобы зрители не выступали пассивными слушателями. Практически всегда успех презентации зависит от хорошего планирования, но уделяйте не меньшее внимание способам выражения идей. Творческая задумка может пойти прахом, если вам в новинку выступать перед большим количеством людей, но используя правильный подход, можно заинтересовать слушателей практически любой темой.\n" +
            "\n" +
            "1) Избавьтесь от волнения перед презентацией. Волнение сложно победить в открытом бою, но его можно значительно ослабить, если обуздать потенциальные факторы стресса. Чрезвычайно важно хорошо выспаться и подготовиться к презентации заранее. Используйте столько времени, сколько необходимо, чтобы почувствовать уверенность в своем проекте.\n" +
            "\n" +
            "2) Заранее обдумайте сценарий. Каждый талантливый докладчик всегда оставляет место для импровизации, но успешная презентация почти всегда опирается на отшлифованный сценарий. Сценарий можно взять с собой на случай, если вы свернете с пути и захотите вернуться на проторенную дорожку.\n" +
            "\n" +
            "3) Говорите не спеша. Неспешный и размеренный темп речи едва ли окажется вашей первой идеей при мысли о творческой презентации. Сама по себе медленная речь лишена творческого оттенка, но она позволяет доносить до аудитории ваши изобретательные замыслы без сучка и задоринки. Постарайтесь замедлить обычный темп речи и вам уже станет проще контролировать свои высказывания.\n" +
            "\n" +
            "4) Проводите презентацию в разговорном стиле. Необходимо четко понимать, о чем вы говорите на презентации, но при этом старайтесь озвучивать свои мысли слегка небрежно. Слушателям не по душе, когда выступление докладчика выглядит как монотонное чтение с листа.\n" +
            "\n" +
            "5) Репетируйте. Репетиции и подготовка станут фундаментом успешной презентации. Лучше говорить перед зеркалом и подобрать такой тон голоса, который подходит для выбранной темы. В процессе репетиций придет осознание того, как правильно подать свой сценарий. Репетируйте в разных местах, чтобы не привыкать к определенным условиям.\n" +
            "\n" +
            "6) Используйте жесты и мимику для выражения мыслей, все движения должны быть плавными и естественными, поддерживайте зрительный контакт с аудиторией.\n" +
            "\n" +
            "7) Одежда должна соответствовать презентации. Зрители сделают первые выводы о вас уже по внешнему виду. Благодаря аккуратной и уместной одежде любые ваши слова будут восприняты всерьез. Также не следует забывать о дезодоранте и прическе. Утром перед выступлением уделите время тому, чтобы привести себя в порядок. Образ успешного докладчика придает уверенности.\n" +
            "Не пытайтесь впечатлить зрителей своим нарядом. Для таких мероприятий принята стандартная форма одежды. Не отходите от правил, иначе вы рискуете предстать на сцене в образе шута.\n" +
            "\n" +
            "8) Используйте простые наглядные материалы (минимализм). Все подробности необходимо сообщать устно.\n" +
            "\n" +
            "9) Используйте забавные картинки, чтобы развлечь зрителей. Смешная картинка поможет разбавить официальный тон презентации, но важно помнить, что не каждая тема допускает юмористические замечания.\n" +
            "\n" +
            "10) Раздаточный материал. Подобные материалы позволяют слушателям не потерять нить презентации. Если ваш доклад опирается на объемный текст, то раздайте присутствующим краткие сведения о ключевых аспектах проекта или вводную информацию. Текстовый раздаточный материал предпочтительнее слайдов.\n" +
            "\n" +
            "11) Не стойте на месте. Помимо уверенного языка тела ведущий должен представлять собой подвижны объект. Расхаживайте по сцене, чтобы слушателям было интересно следить за вами.\n" +
            "Ходите туда и обратно, но не двигайтесь слишком быстро. Лихорадочный темп ассоциируется с волнением. Ваши шаги должны быть уверенными, а осанка – правильной.\n" +
            "\n" +
            "12) Привлеките внимание в начале презентации. Пробудите интерес зрителей к своему проекту вне зависимости от того, насколько они знакомы с темой. Ваши вступительные фразы должны быть максимально понятными. Начните презентацию с увлекательного заявления. Расскажите шутку, подчеркните важность проекта либо используйте поэтическое описание темы, чтобы “достучаться” до аудитории. Задайте общий вопрос, который коснется каждого.\n" +
            "\n" +
            "13) Поощряйте участие аудитории. При долгом бездействии слушатели могут вести себя беспокойно. Большую часть времени именно вы должны оставаться в центре внимания, но задействовать зрителей также полезно. Сразу сообщите, что вы с удовольствием выслушаете вопросы и замечания. Высказав ключевые идеи, делайте паузы и спрашивайте мнение аудитории.\n" +
            "\n" +
            "14) Узнайте мнение слушателей. Если узнать мнение или отношение присутствующих касательно темы вашей презентации, то вы получите возможность превратить свой проект в открытый для обсуждения форум. Свежий взгляд на вопрос от людей, которые еще не слышали о вашем проекте, позволит повысить качество презентации.\n" +
            "\n" +
            "15) Покажите увлеченность проектом. Главным аспектом успешной презентации является степень интереса докладчика к теме. В конечном счете внимательные зрители всегда видят, насколько ведущему интересен материал. Если вы страстно увлечены или одержимы проектом, то всегда сможете передать свой энтузиазм слушателям."
    const val RECOMMENDATION_PROJECT = "Паспорт проекта – краткая характеристика проектной работы, в которой даётся пояснение и описание основных частей работы с обязательным указанием темы, автора, руководителя и предмета, по которому выполняется проектная работа.\n" +
            "\n" +
            "Памятка типов проектов:\n" +
            "1.Практико-ориентированный. Проект нацелен на социальные интересы самих участников проекта или внешнего заказчика. Продукт заранее определен и может быть использован в жизни класса, школы, микрорайона, города, государства. Палитра разнообразна – от учебного пособия для кабинета до рекомендаций по восстановлению экономики России. Важно оценить реальность использования продукта на практике и его способность решить поставленную проблему.\n" +
            "2.Исследовательский проект. По структуре напоминает подлинно научное исследование. Он включает обоснование актуальности выбранной темы, обозначение задач исследования, обязательное выдвижение гипотезы с последующей проверкой, обсуждение полученных результатов. При этом используются методы современной науки: лабораторный эксперимент, моделирование, социологический опрос и другие. Исследовательские проекты - одна из наиболее распространенных форм данного вида деятельности.\n" +
            "3.Информационный проект. Направлен на сбор информации о каком-то объекте, явлении с целью анализа, обобщения и представления для широкой аудитории. Выходом такого проекта часто являются публикации в средствах массовой информации. Результатом такого проекта может быть и создание информационной среды класса или школы. Такие проекты часто интегрируются в исследовательские проекты и становятся их органичной частью.\n" +
            "4. Творческий проект. Предполагает максимально свободный и нетрадиционный подход к оформлению результатов. Это могут быть альманахи, театрализации, спортивные игры, произведения изобразительного или декоративно-прикладного искусства, видеофильмы.\n" +
            "\n" +
            "\n" +
            "Целью проекта может являться:\n" +
            "1. Решение практических задач заказчика проекта\n" +
            "2. Доказательство или опровержение какой-либо гипотезы\n" +
            "3. Сбор информации о каком-либо объекте или явлении\n" +
            "4. Привлечение интереса публики к проблеме проекта\n" +
            "5. Предоставление публике опыта участия в решении проблемы проекта\n" +
            "\n" +
            "Вопрос проекта - это поиск решения проблемы. Это неординарный и многослойный вопрос, отражающий богатство и сложность изучаемого предмета. На этот вопрос нельзя ответить одним предложением, дать односложный ответ типа «да», «можно», «будет» и так далее. Поиск ответа приводит к появлению других важных вопросов. Чаще всего такой вопрос - это название изучаемой темы в вопросительной форме.\n" +
            "\n" +
            "Результатом продукта могут быть: учебные пособия, макеты и модели, инструкции, памятки, рекомендации, результат исследования, оформленный в виде презентаций, стенгазет, буклетов, статистические данные, результаты опросов общественного мнения, обобщение высказываний различных авторов по какому-либо вопросу, представленные в виде журнала, газеты, альманаха, презентации, литературные произведения, произведения изобразительного или декоративно-прикладного искусства, видеофильмы, акции, внеклассные занятия, мероприятие (игра, состязание, викторина, экскурсия и тому подобное)"
    const val RECOMMENDATION_DEFAULT = "DEFAULT"
}