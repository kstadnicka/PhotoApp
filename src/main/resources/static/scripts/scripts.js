function createCalendar() {
    const calendarEl = document.getElementById('calendar');
    calendarEl.innerHTML = '';

    const date = new Date();
    const currentYear = date.getFullYear();
    const currentMonth = date.getMonth();
    const currentDate = date.getDate();

    const monthNames = ["styczeń", "luty", "marzec", "kwiecień", "maj", "czerwiec",
        "lipiec", "sierpień", "wrzesień", "październik", "listopad", "grudzień"];
    calendarEl.innerHTML += `<div class="month-title">${monthNames[currentMonth]} ${currentYear}</div>`;

    const dayNames = ["Pon", "Wt", "Śr", "Czw", "Pt", "Sob", "Nie"];
    dayNames.forEach(day => {
        calendarEl.innerHTML += `<div class="day-name">${day}</div>`;
    });

    const firstDayIndex = (new Date(currentYear, currentMonth, 1).getDay() + 6) % 7;
    const daysInMonth = new Date(currentYear, currentMonth + 1, 0).getDate();

    for (let i = 0; i < firstDayIndex; i++) {
        calendarEl.innerHTML += `<div class="day"></div>`;
    }

    for (let i = 1; i <= daysInMonth; i++) {
        if (i === currentDate) {
            calendarEl.innerHTML += `<div class="day today">${i}</div>`; // Add 'today' class
        } else {
            calendarEl.innerHTML += `<div class="day">${i}</div>`;
        }
    }
}


createCalendar();


document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('clients-toggle').addEventListener('click', function(event) {
        event.preventDefault(); // Prevent the default anchor click behavior
        const subMenu = document.getElementById('clients-sub-menu');
        subMenu.classList.toggle('hidden'); // Show or hide the sub-menu
    });
});
