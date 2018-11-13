<#-- @ftlvariable name="execution" type="com.everwhimsical.jbehave.model.IExecution" -->
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- Bootstrap -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous"/>

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Bootstrap table -->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.css">

    <style>
        body.failure {
            background-color: #dc3545;
        }

        body.success {
            background-color: #28a745;
        }

        .navbar-bg {
            background-color: #fff;
        }

        .carousel-caption {
            position: relative;
            left: auto;
            right: auto;
            bottom: 0;
            padding-bottom: 0;
        }
    </style>

    <title>Slingshot - Execution Report</title>
</head>
<#if execution.status == 'PASSED'>
<body class="success">
<#else>
<body class="failure">
</#if>

<#include "nav.ftl">

<div class="container-fluid">
    <#include "allStories.ftl">
    <#include "allScenarios.ftl">
</div>

<!-- Bootstrap -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

<!-- Bootstrap table -->
<script
    src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>
<script
    src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/extensions/filter-control/bootstrap-table-filter-control.js"></script>

<!-- FileSaver -->
<script
    src="https://cdn.rawgit.com/hhurz/tableExport.jquery.plugin/master/libs/FileSaver/FileSaver.min.js"></script>

<!-- XLSX -->
<script
    src="https://cdn.rawgit.com/hhurz/tableExport.jquery.plugin/master/libs/js-xlsx/xlsx.core.min.js"></script>

<!-- Export plugin -->
<script
    src="https://cdn.rawgit.com/hhurz/tableExport.jquery.plugin/master/tableExport.min.js"></script>

<!-- Bootstrap table export -->
<script type="text/javascript">
    !function (t) {
        "use strict";
        var o = t.fn.bootstrapTable.utils.sprintf, e = {
            json: "JSON",
            xml: "XML",
            png: "PNG",
            csv: "CSV",
            txt: "TXT",
            sql: "SQL",
            doc: "MS-Word",
            excel: "MS-Excel",
            xlsx: "MS-Excel (OpenXML)",
            powerpoint: "MS-Powerpoint",
            pdf: "PDF"
        };
        t.extend(t.fn.bootstrapTable.defaults, {
            showExport: !1,
            exportDataType: "basic",
            exportTypes: ["csv", "xlsx"],
            exportOptions: {fileName: "TestMethods"}
        }), t.extend(t.fn.bootstrapTable.defaults.icons, {export: "fas-lg fa-download"}), t.extend(
            t.fn.bootstrapTable.locales, {
                formatExport: function () {
                    return "Export data"
                }
            }), t.extend(t.fn.bootstrapTable.defaults, t.fn.bootstrapTable.locales);
        var n = t.fn.bootstrapTable.Constructor, i = n.prototype.initToolbar;
        n.prototype.initToolbar = function () {
            if (this.showToolbar = this.showToolbar || this.options.showExport, i.apply(this,
                Array.prototype.slice.apply(arguments)), this.options.showExport) {
                var n = this, s = this.$toolbar.find(">.btn-group"), a = s.find("div.export");
                if (!a.length) {
                    var p = (a = t(['<div class="export btn-group">',
                            '<button class="btn' + o(" btn-%s", this.options.buttonsClass) + o(
                                " btn-%s", this.options.iconSize)
                            + ' dropdown-toggle" aria-label="export type" id="menuExportType"title="'
                            + this.options.formatExport() + '" data-toggle="dropdown" type="button">',
                            o('<i class="%s %s"></i> ', this.options.iconsPrefix,
                                this.options.icons.export), '<span class="caret"></span>', "</button>",
                            '<ul class="dropdown-menu dropdown-menu-right" aria-labelledby="menuExportType" id="menuExportTypeList">',
                            "</ul>", "</div>"].join("")).appendTo(s)).find(".dropdown-menu"),
                        r = this.options.exportTypes;
                    if ("string" == typeof this.options.exportTypes) {
                        var l = this.options.exportTypes.slice(1, -1).replace(/ /g, "").split(",");
                        r = [], t.each(l, function (t, o) {
                            r.push(o.slice(1, -1))
                        })
                    }
                    t.each(r, function (t, o) {
                        e.hasOwnProperty(o) && p.append(['<li data-type="' + o + '">',
                            '<a class="dropdown-item" href="javascript:void(0)">', e[o], "</a>",
                            "</li>"].join(""))
                    }), p.find("li").click(function () {
                        var o = t(this).data("type"), e = function () {
                            if (n.options.exportFooter) {
                                var e = n.getData(), i = n.$tableFooter.find("tr").first(), s = {},
                                    a = [];
                                t.each(i.children(), function (o, e) {
                                    var i = t(e).children(".th-inner").first().html();
                                    s[n.columns[o].field] = "&nbsp;" == i ? null : i, a.push(i)
                                }), n.append(s);
                                var p = n.$body.children().last();
                                t.each(p.children(), function (o, e) {
                                    t(e).html(a[o])
                                })
                            }
                            console.log(n), n.$el.tableExport(t.extend({}, n.options.exportOptions,
                                {type: o, escape: !1})), n.options.exportFooter && n.load(e)
                        }, i = n.header.stateField;
                        if ("all" === n.options.exportDataType && n.options.pagination) {
                            n.$el.one(
                                "server" === n.options.sidePagination ? "post-body.bs.table"
                                    : "page-change.bs.table", function () {
                                    i && n.hideColumn(i), e(), n.togglePagination()
                                }), n.togglePagination();
                        } else if ("selected"
                            === n.options.exportDataType) {
                            var s = n.getData(), a = n.getSelections();
                            if (!a.length) {
                                return;
                            }
                            if ("server" === n.options.sidePagination) {
                                var p = {total: n.options.totalRows};
                                p[n.options.dataField] = s, s = p;
                                var r = {total: a.length};
                                r[n.options.dataField] = a, a = r
                            }
                            n.load(a), i && n.hideColumn(i), e(), n.load(s)
                        } else {
                            i && n.hideColumn(i), e();
                        }
                        i && n.showColumn(i)
                    })
                }
            }
        }
    }(jQuery);
</script>
</body>
</html>