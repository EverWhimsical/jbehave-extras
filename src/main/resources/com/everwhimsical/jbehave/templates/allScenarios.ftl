<#-- @ftlvariable name="execution" type="com.everwhimsical.jbehave.model.IExecution" -->
<div class="row mb-3">
    <div class="col">
        <div class="card">
            <div class="card-header" id="allScenarios">
                <i class="fa fa-align-justify"></i> All Scenarios
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover" data-toggle="table"
                           data-filter-control="true"
                           data-show-export="true">
                        <thead>
                        <tr>
                            <th data-field="scenarioName" data-filter-control="input" data-sortable="true">
                                Scenario Name
                            </th>
                            <th data-field="scenarioInformation" data-filter-control="input" data-sortable="true">
                                Scenario Information
                            </th>
                            <th data-field="steps">
                                Steps
                            </th>
                            <th data-field="timeAndDuration">
                                Time and Duration
                            </th>
                            <th data-field="status" data-filter-control="select"data-sortable="true">Status </th>
                        </tr>
                        </thead>
                        <tbody>
                            <#list execution.stories as iStory>
                                <#list iStory.IScenarios as IScenario>
                                    <tr id="${IScenario.id}">
                                        <td>
                                            ${IScenario.name}
                                        </td>
                                        <td>
                                            <#if IScenario.meta?has_content>&nbsp;[
                                                <#list IScenario.meta as key, value>${key}:${value}</#list>
                                                <br/>
                                            ]</#if>
                                            <#if IScenario.exampleRows?has_content>&nbsp;[
                                                <#list IScenario.exampleRows as key, value>${key}:${value}</#list>
                                            ]</#if>
                                        </td>
                                        <td>
                                            <table class="table table-bordered table-hover" data-toggle="table"
                                               data-filter-control="true"
                                               data-show-export="true">
                                                <thead>
                                                    <tr>
                                                        <th data-field="name">
                                                            Step Name
                                                        </th>
                                                        <th data-field="duration" data-sortable="true">Duration</th>
                                                        <th data-field="status" data-filter-control="select"data-sortable="true">Status </th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <#list IScenario.ISteps as IStep>
                                                    <tr id="${IStep.id}">
                                                        <td>
                                                            ${IStep.annotation} ${IStep.name}
                                                        </td>

                                                        <td>${IStep.duration}</td>
                                                        <td class="text-center">
                                                            <#if IStep.status == 'PASSED'>
                                                                <span class="badge badge-success">PASSED</span>
                                                            <#elseif IStep.status == 'FAILED'>
                                                                <span class="badge badge-danger">FAILED</span>
                                                            <#else>
                                                                <span class="badge badge-warning">SKIPPED</span>
                                                            </#if>
                                                        </td>
                                                    </tr>
                                                    </#list>
                                                    </tbody>
                                                </table>
                                        </td>
                                        <td>
                                            ${formatDateTime(IScenario.startDateTime, "yyyy/MM/dd hh:mm:ss a")}
                                            <br/>${IScenario.duration}
                                        </td>
                                        <td class="text-center">
                                            <#if IScenario.status == 'PASSED'>
                                                <span class="badge badge-success">PASSED</span>
                                            <#elseif IScenario.status == 'FAILED'>
                                                <span class="badge badge-danger">FAILED</span>
                                            <#else>
                                                <span class="badge badge-warning">SKIPPED</span>
                                            </#if>
                                        </td>
                                    </tr>
                                </#list>
                            </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>