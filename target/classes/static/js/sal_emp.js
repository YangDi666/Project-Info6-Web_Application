var name = emp.map(e => e.firstName + ' ' + e.lastName);
var sal = emp.map(e => e.salary);

console.log(name);
console.log(sal);

new Chart(document.getElementById("bar-chart"), {
    type: 'bar',
    data: {
      labels:name.split(','),
      datasets: [
        {
          label: "Salary",
          backgroundColor:"#3e98cd",
          data: sal
        }
      ]
    },
    options: {
      legend: { display: false },
      title: {
        display: true,
        text: 'Salary Histogram for each employee'
      }
    }
});