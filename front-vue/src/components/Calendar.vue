<template>
  <div class="demo-app">
    <!-- <div class="demo-app-top">
      <button @click="toggleWeekends">toggle weekends</button>
      <button @click="gotoPast">go to a date in the past</button>
      (also, click a date/time to add an event)
    </div>-->
    <FullCalendar
      class="demo-app-calendar"
      ref="fullCalendar"
      defaultView="dayGridMonth"
      :header="{
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
      }"
      :plugins="calendarPlugins"
      :weekends="calendarWeekends"
      :events="calendarEvents"
      @dateClick="handleDateClick"
    />
    <br />
    <br />
  </div>
</template>

<script>
import FullCalendar from "@fullcalendar/vue";
import dayGridPlugin from "@fullcalendar/daygrid";
import timeGridPlugin from "@fullcalendar/timegrid";
import interactionPlugin from "@fullcalendar/interaction";

// must manually include stylesheets for each plugin
import "@fullcalendar/core/main.css";
import "@fullcalendar/daygrid/main.css";
import "@fullcalendar/timegrid/main.css";

import Axios from "axios";

export default {
  components: {
    FullCalendar // make the <FullCalendar> tag available
  },
  data: function() {
    return {
      calendarObject: {
        title: "",
        start: "",
        allDay: true, // allDay true인지 어떻게 받아..?
        mem_no: 1 // 임의로 설정
      },
      calendarPlugins: [
        // plugins must be defined in the JS
        dayGridPlugin,
        timeGridPlugin,
        interactionPlugin // needed for dateClick
      ],
      calendarWeekends: true,
      calendarEvents: [
        // initial event data
        // 3. 여기에 사용자가 기존에 저장해놓은 모든 데이터 가져와야 (Calendar table에서 mem_no으로 모든 스케줄 가져와야)
        { title: "Event Now", start: new Date() }
      ]
    };
  },
  methods: {
    // toggleWeekends() {
    //   this.calendarWeekends = !this.calendarWeekends; // update a property
    // },
    // gotoPast() {
    //   let calendarApi = this.$refs.fullCalendar.getApi(); // from the ref="..."
    //   calendarApi.gotoDate("2000-01-01"); // call a method on the Calendar object
    // },
    handleDateClick(arg) {
      const inputValue = prompt(
        arg.dateStr + " 에 어떤 일정을 추가하시겠습니까?"
      );
      if (inputValue) {
        
        // 1) DB에 넣는것
        this.calendarObject.title = inputValue;
        this.calendarObject.start = arg.date;
        
        // title, start 를 잡아야 -
        Axios.post(`http://localhost:8081/Calendar`, this.calendarObject).then(
          res => {
            
          }
        );

        // 2. calendar 내 추가
        this.calendarEvents.push({
          title: inputValue,
          start: arg.date,
          allDay: arg.allDay
        });
      }
    }
  },
  created() {
    // mem_no을 우선 여기서 넣기 (아직 안됨)

    Axios.get(
      `http://localhost:8081/Calendar`,
      this.calendarObject.mem_no
    ).then(res => {
      this.calendarEvents = res.data.data;
      
    });
  }
};
</script>

<style>
.demo-app {
  font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
  font-size: 14px;
}

.demo-app-top {
  margin: 0 0 3em;
}

.demo-app-calendar {
  margin: 0 auto;
  max-width: 900px;
}
</style>
