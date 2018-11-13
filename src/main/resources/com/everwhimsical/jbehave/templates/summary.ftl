<#-- @ftlvariable name="execution" type="com.altimetrik.qe.slingshot.model.Execution" -->
<#-- @ftlvariable name="about" type="com.altimetrik.qe.slingshot.model.About" -->
<#-- @ftlvariable name="formatDateTime" type="com.altimetrik.qe.slingshot.reporter.internal.FormatDateTimeMethodModel" -->
<div class="row mb-3">
    <div class="col-sm">
        <div class="card">
            <div class="card-header" id="summary">
                <i class="fa fa-pie-chart"></i> Execution Summary
                <span class="float-right text-secondary">&nbsp;Started: ${formatDateTime(execution.startDateTime, "yyyy/MM/dd hh:mm:ss a")} UTC&nbsp;/&nbsp;Duration: ${execution.duration}</span>
            </div>

            <div class="card-body">
                <div class="row">
                    <div class="col">
                        <div class="card">
                            <div class="card-header">
                                <span>Test Methods</span>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col">Status</div>
                                    <div class="col">
                                        <#if testMethodSummary.FAILED??>
                                            <span class="badge badge-danger">FAILED</span>
                                        <#elseif testMethodSummary.SKIPPED??>
                                            <span class="badge badge-warning">SKIPPED</span>
                                        <#else>
                                            <span class="badge badge-success">PASSED</span>
                                        </#if>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">Total</div>
                                    <#assign total = 0>
                                    <#if testMethodSummary.PASSED??>
                                        <#assign total += testMethodSummary.PASSED>
                                    </#if>
                                    <#if testMethodSummary.FAILED??>
                                        <#assign total += testMethodSummary.FAILED>
                                    </#if>
                                    <#if testMethodSummary.SKIPPED??>
                                        <#assign total += testMethodSummary.SKIPPED>
                                    </#if>
                                    <div class="col">${total}</div>
                                </div>
                                <div class="row">
                                    <div class="col">Passed</div>
                                    <div class="col">${testMethodSummary.PASSED!0}</div>
                                </div>
                                <div class="row">
                                    <div class="col">Failed</div>
                                    <div class="col">${testMethodSummary.FAILED!0}</div>
                                </div>
                                <div class="row">
                                    <div class="col">Skipped</div>
                                    <div class="col">${testMethodSummary.SKIPPED!0}</div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col">
                        <div class="card">
                            <div class="card-header">
                                <span>Tests</span>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col">Status</div>
                                    <div class="col">
                                        <#if testSummary.FAILED??>
                                            <span class="badge badge-danger">FAILED</span>
                                        <#elseif testSummary.SKIPPED??>
                                            <span class="badge badge-warning">SKIPPED</span>
                                        <#else>
                                            <span class="badge badge-success">PASSED</span>
                                        </#if>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">Total</div>
                                    <#assign total = 0>
                                    <#if testSummary.PASSED??>
                                        <#assign total += testSummary.PASSED>
                                    </#if>
                                    <#if testSummary.FAILED??>
                                        <#assign total += testSummary.FAILED>
                                    </#if>
                                    <#if testSummary.SKIPPED??>
                                        <#assign total += testSummary.SKIPPED>
                                    </#if>
                                    <div class="col">${total}</div>
                                </div>
                                <div class="row">
                                    <div class="col">Passed</div>
                                    <div class="col">${testSummary.PASSED!0}</div>
                                </div>
                                <div class="row">
                                    <div class="col">Failed</div>
                                    <div class="col">${testSummary.FAILED!0}</div>
                                </div>
                                <div class="row">
                                    <div class="col">Skipped</div>
                                    <div class="col">${testSummary.SKIPPED!0}</div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col">
                        <div class="card">
                            <div class="card-header">
                                <span>Suites</span>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col">Status</div>
                                    <div class="col">
                                        <#if suiteSummary.FAILED??>
                                            <span class="badge badge-danger">FAILED</span>
                                        <#elseif suiteSummary.SKIPPED??>
                                            <span class="badge badge-warning">SKIPPED</span>
                                        <#else>
                                            <span class="badge badge-success">PASSED</span>
                                        </#if>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">Total</div>
                                    <#assign total = 0>
                                    <#if suiteSummary.PASSED??>
                                        <#assign total += suiteSummary.PASSED>
                                    </#if>
                                    <#if suiteSummary.FAILED??>
                                        <#assign total += suiteSummary.FAILED>
                                    </#if>
                                    <#if suiteSummary.SKIPPED??>
                                        <#assign total += suiteSummary.SKIPPED>
                                    </#if>
                                    <div class="col">${total}</div>
                                </div>
                                <div class="row">
                                    <div class="col">Passed</div>
                                    <div class="col">${suiteSummary.PASSED!0}</div>
                                </div>
                                <div class="row">
                                    <div class="col">Failed</div>
                                    <div class="col">${suiteSummary.FAILED!0}</div>
                                </div>
                                <div class="row">
                                    <div class="col">Skipped</div>
                                    <div class="col">${suiteSummary.SKIPPED!0}</div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col">
                        <div class="card">
                            <div class="card-header">About</div>
                            <div class="card-body">
                                <div class="row">
                                    <span class="col">Project Name</span>
                                    <span class="col">${about.projectName}</span>
                                </div>

                                <div class="row">
                                    <span class="col">Environment</span>
                                    <span class="col">${about.environment}</span>
                                </div>

                                <div class="row">
                                    <span class="col">Release</span>
                                    <span class="col">${about.releaseVersion}</span>
                                </div>

                                <div class="row">
                                    <span class="col">Platform</span>
                                    <span class="col">${about.executionOS}</span>
                                </div>

                                <div class="row">
                                    <span class="col">Username</span>
                                    <span class="col">${about.userName}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>