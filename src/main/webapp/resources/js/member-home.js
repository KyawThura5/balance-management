/**
 * 
 */
document.addEventListener('DOMContentLoaded', () => {

	am5.ready(() => {
		loadBalanceChart()
	})

})

function loadBalanceChart() {


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

	var data = [
		{
			"date": "2025/05/01",
			"incomes": 500000,
			"expenses": 20000
		}, {
			"date": "2025/05/02",
			"incomes": 400000,
			"expenses": 60000
		}, {
			"date": "2025/05/03",
			"incomes": 500000,
			"expenses": 30000
		},
		{
			"date": "2025/05/04",
			"incomes": 600000,
			"expenses": 20000
		},
		{
			"date": "2025/05/05",
			"incomes": 200000,
			"expenses": 50000
		}
	]


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