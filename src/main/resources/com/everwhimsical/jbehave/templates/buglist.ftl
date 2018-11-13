<#-- @ftlvariable name="execution" type="com.altimetrik.qe.slingshot.model.Execution" -->
<div class="row mb-3">
    <div class="col">
        <div class="card">
            <div class="card-header" id="allBugs">
                <i class="fa fa-bug"></i> All Failures
            </div>
            <div class="card-body">
                <div class="accordion" id="bugListAccordion">
                    <#list execution.bugListMap?keys as bugMessage>
                        <div class="card">
                            <a href="#" class="text-danger" data-toggle="collapse"
                               data-target="#bugCollapse${bugMessage_index}" aria-expanded="true"
                               aria-controls="bugCollapse${bugMessage_index}">
                                <div class="card-header" id="bug${bugMessage_index}">
                                    <div class="row">
                                        <div class="col-10 text-truncate">
                                            ${bugMessage?html}
                                        </div>
                                        <div class="col">
                                            <span
                                                class="badge badge-danger badge-pill float-right">${execution.bugListMap[bugMessage]?size} Test Methods</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                            <div id="bugCollapse${bugMessage_index}" class="collapse"
                                 aria-labelledby="bug${bugMessage_index}"
                                 data-parent="#bugListAccordion">
                                <div class="card-body">
                                    <table class="table table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th>Test Method</th>
                                            <th>Test</th>
                                            <th>Suite</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                            <#list execution.bugListMap[bugMessage] as testMethod>
                                            <tr>
                                                <td>
                                                    <a href="#${testMethod.testMethodId}">
                                                        ${testMethod.name}<#if testMethod.description??>
                                                        &nbsp;[${testMethod.description}]</#if>
                                                    </a>
                                                </td>
                                                <td>${testMethod.test}</td>
                                                <td>${testMethod.suite}</td>
                                            </tr>
                                            </#list>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
        </div>
    </div>
</div>