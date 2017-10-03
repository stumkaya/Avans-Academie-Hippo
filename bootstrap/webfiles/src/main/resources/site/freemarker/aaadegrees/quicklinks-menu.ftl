<#include "../include/imports.ftl">

<section class="quick-nav quick-nav--black-link">
  <nav class="navbar navbar-default">
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <div class="quick-nav-wrapper">
            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
              Dropdown
            </button>
            <ul class="nav navbar-nav quick-nav-container"></ul>
          </div>
        </div>
      </div>
    </div>
  </nav>
</section>

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
<script type="text/javascript" src="<@hst.webfile path="/js/vendor/scrollspy.js" />"></script>
</@hst.headContribution>
<@hst.headContribution category="htmlBodyEnd">
<script type="text/javascript" src="<@hst.webfile path="/js/scripts.min.js" />"></script>
</@hst.headContribution>

 <#--       <#list menu.siteMenuItems as item>
            <#assign anchor>${item.getParameter("Anchor")?replace(" ", "_")}</#assign>
            <#if !item.hstLink?? && !item.externalLink??>
                <#if item.selected || item.expanded>

                  <li class="active"><div style="padding: 10px 15px;"><a href="#${anchor}">${item.name?html}</a></div></li>
                <#else>
                  <li><div style="padding: 10px 15px;"><a href="#${anchor}">${item.name?html}</a></div></li>
                </#if>
            <#else>
                <#if item.hstLink??>
                    <#assign href><@hst.link link=item.hstLink/></#assign>
                <#elseif item.externalLink??>
                    <#assign href>${item.externalLink?replace("\"", "")}</#assign>
                </#if>
                <#if  item.selected || item.expanded>
                  <li class="active"><a href="${href}">${item.name?html}</a></li>
                <#else>
                  <li><a href="${href}">${item.name?html}</a></li>
                </#if>
            </#if>
        </#list>
-->


