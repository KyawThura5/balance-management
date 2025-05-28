/**
 * 
 */
document.addEventListener('DOMContentLoaded', () => {

	am5.ready(() => {
		loadBalanceChart(BalanceData)
		loadPieChart(ExpensesData, 'expensesChart')
		loadPieChart(IncomesData, 'incomesChart')
	})

})

const BalanceData = [
		{
			"date": "2025/05/01",
			"expenses": 200000,
			"incomes": 500000
		}, {
			"date": "2025/05/02",
			"expenses": 10000,
			"incomes": 500000
		}, {
			"date": "2025/05/03",
			"expenses": 40000,
			"incomes": 300000
		},
		{
			"date": "2025/05/04",
			"expenses": 250000,
			"incomes": 700000
		},
		{
			"date": "2025/05/05",
			"expenses": 4500,
			"incomes": 60000
		}
	]

const IncomesData = [{
	  ledger: "Phone Service",
	  value: 501.9
	}, {
	  ledger: "laptop Sevice",
	  value: 301.9
	}, {
	  ledger: "PowerBank Service",
	  value: 201.1
	}]
	
const ExpensesData = [{
		  ledger: "Phone Service",
		  value: 501.9
		}, {
		  ledger: "laptop Sevice",
		  value: 301.9
		}, {
		  ledger: "PowerBank Service",
		  value: 201.1
		}]
		
		
function loadPieChart(data, chartdiv){

	// Create root element
	// https://www.amcharts.com/docs/v5/getting-started/#Root_element
	var root = am5.Root.new(chartdiv);

	// Set themes
	// https://www.amcharts.com/docs/v5/concepts/themes/
	root.setThemes([
	  am5themes_Animated.new(root)
	]);

	// Create chart
	// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/
	var chart = root.container.children.push(
	  am5percent.PieChart.new(root, {
	    endAngle: 270
	  })
	);

	// Create series
	// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/#Series
	var series = chart.series.push(
	  am5percent.PieSeries.new(root, {
	    valueField: "value",
	    categoryField: "ledger",
	    endAngle: 270
	  })
	);

	series.states.create("hidden", {
	  endAngle: -90
	});
	series.labels.template.setAll({
		visible: false
	});
	
	series.ticks.template.setAll({
		visible: false
	});
	series.data.setAll(data);  
	series.appear(1000, 100);
}



function loadBalanceChart(data) {


	// Create root element
	// https://www.amcharts.com/docs/v5/getting-started/#Root_element
	var root = am5.Root.new("balanceChart");


	// Set themes
	// https://www.amcharts.com/docs/v5/concepts/themes/
	root.setThemes([
		am5themes_Animated.new(root)
	]);


	// Create chart
	// https://www.amcharts.com/docs/v5/charts/xy-chart/
	var chart = root.container.children.push(am5xy.XYChart.new(root, {
		panX: false,
		panY: false,
		paddingLeft: 0,
		wheelX: "panX",
		wheelY: "zoomX",
		layout: root.verticalLayout
	}));


	// Add legend
	// https://www.amcharts.com/docs/v5/charts/xy-chart/legend-xy-series/
	var legend = chart.children.push(
		am5.Legend.new(root, {
			centerX: am5.p50,
			x: am5.p50
		})
	);


	// Create axes
	// https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
	var xRenderer = am5xy.AxisRendererX.new(root, {
		cellStartLocation: 0.1,
		cellEndLocation: 0.9,
		minorGridEnabled: true
	})

	var xAxis = chart.xAxes.push(am5xy.CategoryAxis.new(root, {
		categoryField: "date",
		renderer: xRenderer,
		tooltip: am5.Tooltip.new(root, {})
	}));

	xRenderer.grid.template.setAll({
		location: 1
	})

	xAxis.data.setAll(data);

	var yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
		renderer: am5xy.AxisRendererY.new(root, {
			strokeOpacity: 0.1
		})
	}));


	// Add series
	// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
	function makeSeries(name, fieldName) {
		var series = chart.series.push(am5xy.ColumnSeries.new(root, {
			name: name,
			xAxis: xAxis,
			yAxis: yAxis,
			valueYField: fieldName,
			categoryXField: "date"
		}));

		series.columns.template.setAll({
			tooltipText: "{name}, {categoryX}:{valueY}",
			width: am5.percent(90),
			tooltipY: 0,
			strokeOpacity: 0
		});

		series.data.setAll(data);

		// Make stuff animate on load
		// https://www.amcharts.com/docs/v5/concepts/animations/
		series.appear();

		series.bullets.push(function() {
			return am5.Bullet.new(root, {
				locationY: 0,
				sprite: am5.Label.new(root, {
					text: "{valueY}",
					fill: root.interfaceColors.get("alternativeText"),
					centerY: 0,
					centerX: am5.p50,
					populateText: true
				})
			});
		});

		legend.data.push(series);
	}

	makeSeries("Incomes", "incomes");
	makeSeries("Expenses", "expenses");



	// Make stuff animate on load
	// https://www.amcharts.com/docs/v5/concepts/animations/
	chart.appear(1000, 100);

} // end am5.ready()