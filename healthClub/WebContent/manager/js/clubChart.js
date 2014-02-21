$(function () {
	$(function () {
		var data=eval(document.getElementById("data").innerHTML);
        $('#container').highcharts({
            chart: {
                type: 'area'
            },
            title: {
                text: '每日会员人数'
            },
            xAxis: {
                labels: {
                    formatter: function() {
                        return this.value; // clean, unformatted number for year
                    }
                }
            },
            yAxis: {
                title: {
                    text: '人数'
                },
                labels: {
                    formatter: function() {
                        return this.value;
                    }
                }
            },
            tooltip: {
                pointFormat: '{series.name} produced <b>{point.y:,.0f}</b><br/>warheads in {point.x}'
            },
            plotOptions: {
                area: {
                    pointStart: 1,
                    marker: {
                        enabled: false,
                        symbol: 'circle',
                        radius: 2,
                        states: {
                            hover: {
                                enabled: true
                            }
                        }
                    }
                }
            },
            series: [{
                name: '人数',
                data:data
            }]
        });
    });
});