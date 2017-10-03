<#include "../include/imports.ftl">
<#if document??>
    <@hst.cmseditlink hippobean=document/>
<div class="component-tab">
    <#if document.stickymenuitem?? && document.stickymenuitem?has_content>
      <a class="anchor" id="${document.stickymenuitem?lower_case?replace(" ", "_")}" name="${document.stickymenuitem}" data-name="${document.stickymenuitem}"></a>
    </#if>
  <header>
    <span class="chapeau">${document.chapeau}</span>
    <h2>${document.title}</h2>
  </header>
  <div class="panel-group" id="tc" role="tablist" aria-multiselectable="true">
      <#list document.year as year>
        <div class="panel panel-default">
          <div class="panel-heading" role="tab" id="th1">
            <h4 class="panel-title">
              <a role="button" data-toggle="collapse" data-parent="#tc" href="#c${year_index}" aria-expanded="true" aria-controls="c${year_index}">
              ${year.title}
              </a>
            </h4>
          </div>
          <div id="c${year_index}" class="panel-collapse collapse <#if year_index == 0>in</#if>" role="tabpanel" aria-labelledby="th1">
            <div class="panel-body">
              <div class="component-content">
                  <@hst.html hippohtml=year.content/>
              </div>
            </div>
          </div>
        </div>
      </#list>
  </div>
</div>
</#if>


<@hst.headContribution category="htmlBodyEnd">
<script type="text/javascript" src="<@hst.webfile path="/js/vendor/jquery.min.js" />"></script>
</@hst.headContribution>
<@hst.headContribution category="htmlBodyEnd">
<script type="text/javascript" src="<@hst.webfile path="/js/vendor/bootstrap.min.js" />"></script>
</@hst.headContribution>
<@hst.headContribution category="htmlBodyEnd">
<script type="text/javascript" src="<@hst.webfile path="/js/vendor/jquery.cycle2.min.js" />"></script>
</@hst.headContribution>
<@hst.headContribution category="htmlBodyEnd">
<script type="text/javascript" src="<@hst.webfile path="/js/scripts.min.js" />"></script>
</@hst.headContribution>
<@hst.headContribution category="htmlBodyEnd">
<script type="text/javascript" src="<@hst.webfile path="/js/vendor/scrollspy.js" />"></script>
</@hst.headContribution>
