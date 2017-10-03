<#include "../include/imports.ftl">
<#-- @ftlvariable name="document" type="nl.avans.beans.Studiesoverview" -->

<div class="container">
  <div class="row">
    <section class="col-xs-12">
      <div class="component-overview">

        <div class="row">
          <div class="col-xs-12 col-sm-9 col-md-7">
          <@hst.html hippohtml=document.description/>
          </div>
        </div>

        <div class="row cards">
        <#list document.studies as study>
          <div class="col-sm-6 col-md-4">
            <a href="<@hst.link path=study.link/>" class="image-card">
              <div>
                <img src="<@hst.link hippobean=study.image/>" alt="<#if study.image.description??>${study.image.description}</#if>" />
              </div>
              <header>
                <h3>${study.title}</h3>
                <h4>${study.subtitle}</h4>
              </header>
            </a>
          </div>
        </#list>

        </div>
      </div>
    </section>
  </div>
</div>

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