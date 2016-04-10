$(function() {

    Morris.Area({
        element: 'morris-area-chart',
        data: [{
            period: '2010 Q1',
            iphone: 22.5,
            ipad: 22.5,
            itouch: 22.5
        }, {
            period: '2010 Q2',
            iphone: 22.5,
            ipad: 22.5,
            itouch: 22.5
        }, {
            period: '2010 Q3',
            iphone: 24.5,
            ipad: 24.5,
            itouch: 24.5
        }, {
            period: '2010 Q4',
            iphone: 25,
            ipad: 25,
            itouch: 25
        }, {
            period: '2011 Q1',
            iphone: 27,
            ipad: 27,
            itouch: 27
        }, {
            period: '2011 Q2',
            iphone: 27,
            ipad: 27,
            itouch: 27
        }, {
            period: '2011 Q3',
            iphone: 29,
            ipad: 29,
            itouch: 29
        }, {
            period: '2011 Q4',
            iphone: 29,
            ipad: 29,
            itouch: 29
        }, {
            period: '2012 Q1',
            iphone: 33,
            ipad: 33,
            itouch: 33
        }, {
            period: '2012 Q2',
            iphone: 33,
            ipad: 33,
            itouch: 33
        }],
        xkey: 'period',
        ykeys: ['iphone'],
        labels: ['iPhone', 'iPad', 'iPod Touch'],
        pointSize: 2,
        hideHover: 'auto',
        resize: true
    });

    Morris.Donut({
        element: 'morris-donut-chart',
        data: [{
            label: "Download Sales",
            value: 12
        }, {
            label: "In-Store Sales",
            value: 30
        }, {
            label: "Mail-Order Sales",
            value: 20
        }],
        resize: true
    });

    Morris.Bar({
        element: 'morris-bar-chart',
        data: [{
            y: '2006',
            a: 100,
            b: 90
        }, {
            y: '2007',
            a: 75,
            b: 65
        }, {
            y: '2008',
            a: 50,
            b: 40
        }, {
            y: '2009',
            a: 75,
            b: 65
        }, {
            y: '2010',
            a: 50,
            b: 40
        }, {
            y: '2011',
            a: 75,
            b: 65
        }, {
            y: '2012',
            a: 100,
            b: 90
        }],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['Series A', 'Series B'],
        hideHover: 'auto',
        resize: true
    });

});
