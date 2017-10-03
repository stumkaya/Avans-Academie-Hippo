<#include "../include/imports.ftl">

<#-- @ftlvariable name="menu" type="org.hippoecm.hst.core.sitemenu.HstSiteMenu" -->
<#-- @ftlvariable name="editMode" type="java.lang.Boolean"-->

<!-- Collect the nav links, forms, and other content for toggling -->
<div class="main-menu">
  <div class="main-menu-left">
    <div>
    <ul>
    <#if menu??>
        <#if menu.siteMenuItems??>
            <#list menu.siteMenuItems as item>
                <#if item.name?starts_with('Separator')>
                </ul>
                <ul>
                <#else>
                    <#if item.hstLink??>
                        <#assign href><@hst.link link=item.hstLink/></#assign>
                    <#elseif item.externalLink??>
                        <#assign href>${item.externalLink?replace("\"", "")}</#assign>
                    <#else>
                        <#assign href></#assign>
                    </#if>
                  <li class="menu-item">
                    <a href="${href}">${item.name?html}</a>
                      <#if item.childMenuItems?? && item.childMenuItems?has_content>
                        <span class="menu-item-toggle"></span>
                        <div>
                          <ul>
                              <#list item.childMenuItems as subitem>
                                  <#if subitem.hstLink??>
                                      <#assign href><@hst.link link=subitem.hstLink/></#assign>
                                  <#elseif subitem.externalLink??>
                                      <#assign href>${subitem.externalLink?replace("\"", "")}</#assign>
                                  <#else>
                                      <#assign href></#assign>
                                  </#if>
                                <li><a href="${href}">${subitem.name?html}</a></li>
                              </#list>
                          </ul>
                        </div>
                      </#if>
                  </li>
                </#if>
            </#list>
        </#if>
        <@hst.cmseditmenu menu=menu/>
    </#if>
    </ul>
    </div>
  </div>
  <div class="main-menu-right">
    <ul>
      <!--Search has not yet been implemented.-->
      <li><a href="#" class="search-toggle white"><svg xmlns="http://www.w3.org/2000/svg" xmlns:svg="http://www.w3.org/2000/svg" class="svg svg-search">
<g>
<g class="a">
<g class="b">
<path d="m18.8,13.5c0,-1.5 -0.5,-2.8 -1.5,-3.8c-1.1,-1.1 -2.4,-1.6 -3.8,-1.6c-1.5,0 -2.8,0.5 -3.8,1.6c-1.1,1 -1.6,2.3 -1.6,3.8c0,1.4 0.5,2.7 1.6,3.8c1,1 2.3,1.5 3.8,1.5c1.4,0 2.7,-0.5 3.8,-1.5c1,-1.1 1.5,-2.4 1.5,-3.8zm6.2,10c0,0.4 -0.2,0.7 -0.5,1c-0.3,0.3 -0.6,0.5 -1,0.5c-0.5,0 -0.8,-0.2 -1.1,-0.5l-4.1,-4.1c-1.5,1 -3.1,1.5 -4.8,1.5c-1.2,0 -2.3,-0.2 -3.3,-0.6c-1.1,-0.5 -2,-1.1 -2.7,-1.8c-0.8,-0.8 -1.4,-1.7 -1.8,-2.8c-0.5,-1 -0.7,-2.1 -0.7,-3.2c0,-1.2 0.2,-2.3 0.7,-3.3c0.4,-1.1 1,-2 1.8,-2.7c0.7,-0.8 1.6,-1.4 2.7,-1.8c1,-0.5 2.1,-0.7 3.3,-0.7c1.1,0 2.2,0.2 3.2,0.7c1.1,0.4 2,1 2.8,1.8c0.7,0.7 1.3,1.6 1.8,2.7c0.4,1 0.6,2.1 0.6,3.3c0,1.7 -0.5,3.3 -1.5,4.8l4.2,4.1c0.3,0.3 0.4,0.6 0.4,1.1z" id="svg_3"/>
</g>
</g>
</g>
</svg></a></li>
      <li><a href="#" class="menu-hide white">
        <svg xmlns="http://www.w3.org/2000/svg" class="svg svg-close">
          <g>
            <g class="a">
              <g class="b">
                <path d="m15,12.2l-9.2,-9.2l-2.8,2.8l9.2,9.2l-9.2,9.2l2.8,2.8l9.2,-9.2l9.2,9.2l2.8,-2.8l-9.2,-9.2l9.2,-9.2l-2.8,-2.8l-9.2,9.2z"/>
              </g>
            </g>
          </g>
        </svg>
      </a></li>
    </ul>
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
<script type="text/javascript" src="<@hst.webfile path="/js/scripts.min.js" />"></script>
</@hst.headContribution>
<@hst.headContribution category="htmlBodyEnd">
<script type="text/javascript" src="<@hst.webfile path="/js/vendor/scrollspy.js" />"></script>
</@hst.headContribution>
<#import "google-analytics.ftl" as analytics>
<@analytics.analytics/>