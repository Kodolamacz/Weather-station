
/**
 * Created by Blazej on 03.01.2018.
 */
function renderPlot(data) {
    $("#myChart").empty();
    $("#underChart").empty();
    //$("#dataTable tr").remove();


    // console.log(data.values);
    // console.log(data.hum);

    var sensorName = data.sensor.name;
    var temp_press = data.values;
    var hum = data.hum;
    var values,series;
    var totalV;
    if(hum !== 'undefined'){
        values = [temp_press,hum];
        series = [
            {label: 'Wartość ' + data.unit},
            {label: 'Wartosc ' + data.humUnit}];
        totalV = temp_press.concat(hum);
    }
    else {
        values = [temp_press];
        series = [{label:'Wartość ' + data.unit}];
        totalV = temp_press;
    }

    $.jqplot("myChart", values, {
        title: "<h2> Wykres czujnika " + sensorName + " </h2>",
        series: series,
        axes: {
            xaxis: {
                label: 'Czas',
                pad: 0
            }
        },
        legend: {
            show: true,
            placement: 'outsideGrid'
        }
    });

    var times = data.time;

    //console.log(totalV);
    var t = $('#dataTable').DataTable();

    t.clear();

    for (var i = 0; i < times.length; i++) {
        var x = i+1;
        //console.log('IN');
       t.row.add([x,totalV[i],times[i]]).draw(false);
    }

}

function renderError() {
    $("#myChart").empty();

}

function reloadPlot(sensorCode) {
    console.log("reload");
    $.ajax({
        url: encodeURI('/chart/data/' + sensorCode),
        type: "GET",
        dataType: "json",
        success: renderPlot,
        error: renderError
    });
}

function loadData(sensorCode,begin,end,min,max) {

    $.ajax({
        url: encodeURI('/chart/data/' + sensorCode+'/'+begin+'/'+end+'/'+min+'/'+max),
        type: "GET",
        dataType: "json",
        success: renderPlot,
        error: renderError
    });
}

function initializeChart() {
    $("#showDataButton").click(function() {

        var sensorCode = $("#dropdown").val();

        reloadPlot(sensorCode);
    });

    //reloadPlot($("#dropdown :selected").val());
}
function initializeFilterChart() {
    $("#filterButton").click(function () {

        var sensorCode = $("#dropdown").val();
        var begin = $("#beginDate").val();
        var end = $("#endDate").val();
        var minVal = $("#min").val();
        var maxVal = $("#max").val();
        loadData(sensorCode,begin,end,minVal,maxVal);

    });
}
$(document).ready(initializeChart);
$(document).ready(initializeFilterChart);
// $(document).ready(function(){
//     $("#beginDate").datepicker;
//     $("#endDate").datepicker;
// });


