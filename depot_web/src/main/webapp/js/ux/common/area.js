$(function () {
    $('#province').combobox({
        url: "/depot_background/tabArea/queryListByAreaDeep.do?areaDeep=1",
        valueField: 'area_id',
        textField: 'area_name',
        onSelect: function (rec) {
            $('#city').combobox('clear');
            var url = '/depot_background/tabArea/queryListByParentId.do?parent_id=' + rec.area_id;
            $('#city').combobox('reload', url);
        }
    });

    $('#city').combobox({
        url: "/depot_background/tabArea/queryListByAreaDeep.do?areaDeep=2",
        valueField: 'area_id',
        textField: 'area_name',
        onSelect: function (rec) {
            $('#area').combobox('clear');
            var url = '/depot_background/tabArea/queryListByParentId.do?parent_id=' + rec.area_id;
            $('#area').combobox('reload', url);
        }
    });

    $('#area').combobox({
        url: "/depot_background/tabArea/queryListByAreaDeep.do?areaDeep=3",
        valueField: 'area_id',
        textField: 'area_name',
    });
});
