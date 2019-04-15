
sal.sort(function(a, b) {
	  return b - a;
});
var len =  sal.length;
var per10 = [Math.floor(len*.1) - 1,
			 Math.floor(len*.2) - 1,
			 Math.floor(len*.3) - 1,
			 Math.floor(len*.4) - 1,
			 Math.floor(len*.5) - 1,
			 Math.floor(len*.6) - 1,
			 Math.floor(len*.7) - 1,
			 Math.floor(len*.8) - 1,
			 Math.floor(len*.9) - 1];
var avr = [sal.slice(0, per10[0] + 1).reduce((previous, current) => current += previous) / (per10[0] + 1),
		   sal.slice(per10[0] + 1, per10[1] + 1).reduce((previous, current) => current += previous) / (per10[1] - per10[0]),
		   sal.slice(per10[1] + 1, per10[2] + 1).reduce((previous, current) => current += previous) / (per10[2] - per10[1]),
		   sal.slice(per10[2] + 1, per10[3] + 1).reduce((previous, current) => current += previous) / (per10[3] - per10[2]),
		   sal.slice(per10[3] + 1, per10[4] + 1).reduce((previous, current) => current += previous) / (per10[4] - per10[3]),
		   sal.slice(per10[4] + 1, per10[5] + 1).reduce((previous, current) => current += previous) / (per10[5] - per10[4]),
		   sal.slice(per10[5] + 1, per10[6] + 1).reduce((previous, current) => current += previous) / (per10[6] - per10[5]),
		   sal.slice(per10[6] + 1, per10[7] + 1).reduce((previous, current) => current += previous) / (per10[7] - per10[6]),
		   sal.slice(per10[7] + 1, per10[8] + 1).reduce((previous, current) => current += previous) / (per10[8] - per10[7]),
		   sal.slice(per10[8] + 1, sal.length + 1).reduce((previous, current) => current += previous) / (sal.length - per10[8]) - 1];
console.log(avr);

new Chart(document.getElementById("decile-chart"), {
    type: 'bar',
    data: {
      labels: ["0-10%", "10-20%", "20-30%", "30-40%", "40-50%", "50-60%", "60-70%", "70-80%", "80-90%", "90-100%"],
      datasets: [{
        label: "Percentage (%)",
        backgroundColor: "#3e98cd",
        data: avr
      }]
    },
    options: {
      title: {
        display: true,
        text: 'Salary of the percentage of employees per decile'
      }
    }
});