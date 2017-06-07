$( document ).ready(function() {
    scheduler.config.multi_day = false;
    scheduler.config.xml_date="%Y-%m-%d %H:%i";
    scheduler.config.first_hour = 8;
    scheduler.config.last_hour = 18;
    scheduler.config.readonly = true;
    scheduler.ignore_month = function(date){
        if (date.getDay() == 6 || date.getDay() == 0) //hides Saturdays and Sundays
            return true;
    };
    scheduler.ignore_week = function(date){
        if (date.getDay() == 6 || date.getDay() == 0) //hides Saturdays and Sundays
            return true;
    };
    scheduler.attachEvent("onTemplatesReady", function(){
        scheduler.templates.event_text=function(start,end,event){
            return "<b>" + event.text + "</b><br/>" + event.intervenant + "<br/>" + event.location;
        }
    });

    scheduler.init('scheduler_here',new Date(),"week");
    scheduler.load("/data/promo1.ical","ical");
});

function show_minical(){
    if (scheduler.isCalendarVisible())
        scheduler.destroyCalendar();
    else
        scheduler.renderCalendar({
            position:"dhx_minical_icon",
            date:scheduler._date,
            navigation:true,
            handler:function(date,calendar){
                scheduler.setCurrentView(date);
                scheduler.destroyCalendar()
            }
        });
}