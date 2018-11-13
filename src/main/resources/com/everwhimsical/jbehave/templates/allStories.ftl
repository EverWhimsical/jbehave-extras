<#-- @ftlvariable name="execution" type="com.everwhimsical.jbehave.model.IExecution" -->
<div class="row mb-3">
    <div class="col">
        <div class="card">
            <div class="card-header" id="allScenarios">
                <i class="fa fa-align-justify"></i> All Stories
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover" data-toggle="table"
                           data-filter-control="true"
                           data-show-export="true">
                        <thead>
                        <tr>
                            <th data-field="name" data-filter-control="input" data-sortable="true">
                                Story Name
                            </th>
                            <th data-field="description" data-filter-control="input" data-sortable="true">
                                Story Path
                            </th>
                            <th data-field="startDateTime" data-filter-control="input" data-sortable="true">
                                Start Time
                            </th>
                            <th data-field="duration" data-sortable="true">Duration</th>
                            <th data-field="status" data-filter-control="select"data-sortable="true">Status </th>
                        </tr>
                        </thead>
                        <tbody>
                            <#list execution.stories as iStory>
                            <tr id="${iStory.id}">
                                <td>
                                    ${iStory.name}
                                    <#if iStory.description?has_content>&nbsp;[${iStory.description}]</#if>
                                </td>
                                <td>${iStory.path}</td>
                                <td>${formatDateTime(iStory.startDateTime, "yyyy/MM/dd hh:mm:ss a")}</td>
                                <td>${iStory.duration}</td>
                                <td class="text-center">
                                    <#if iStory.status == 'PASSED'>
                                        <span class="badge badge-success">PASSED</span>
                                    <#elseif iStory.status == 'FAILED'>
                                        <span class="badge badge-danger">FAILED</span>
                                    <#else>
                                        <span class="badge badge-warning">SKIPPED</span>
                                    </#if>
                                </td>
                            </tr>
                            </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>