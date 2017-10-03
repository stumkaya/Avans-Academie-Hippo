<#include "../include/imports.ftl">

<#-- @ftlvariable name="menu" type="org.hippoecm.hst.core.sitemenu.HstSiteMenu" -->
<#-- @ftlvariable name="editMode" type="java.lang.Boolean"-->

<#if menu??>
    <#if menu.siteMenuItems??>
        <#list menu.siteMenuItems as item>
            <#if !item.hstLink?? && !item.externalLink??>
            <li>${item.name?html}</li>
            <#else>
                <#if item.hstLink??>
                    <#assign href><@hst.link link=item.hstLink/></#assign>
                <#elseif item.externalLink??>
                    <#assign href>${item.externalLink?replace("\"", "")}</#assign>
                </#if>
            <li><a href="${href}">${item.name?html}</a></li>
            </#if>
        </#list>
    </#if>
    <@hst.cmseditmenu menu=menu/>
</#if>

<li class="search-toggle static-link"><a href="#">
  <svg xmlns="http://www.w3.org/2000/svg" class="svg svg-search">
    <g>
      <g class="a">
        <g class="b">
          <path d="m18.8,13.5c0,-1.5 -0.5,-2.8 -1.5,-3.8c-1.1,-1.1 -2.4,-1.6 -3.8,-1.6c-1.5,0 -2.8,0.5 -3.8,1.6c-1.1,1 -1.6,2.3 -1.6,3.8c0,1.4 0.5,2.7 1.6,3.8c1,1 2.3,1.5 3.8,1.5c1.4,0 2.7,-0.5 3.8,-1.5c1,-1.1 1.5,-2.4 1.5,-3.8zm6.2,10c0,0.4 -0.2,0.7 -0.5,1c-0.3,0.3 -0.6,0.5 -1,0.5c-0.5,0 -0.8,-0.2 -1.1,-0.5l-4.1,-4.1c-1.5,1 -3.1,1.5 -4.8,1.5c-1.2,0 -2.3,-0.2 -3.3,-0.6c-1.1,-0.5 -2,-1.1 -2.7,-1.8c-0.8,-0.8 -1.4,-1.7 -1.8,-2.8c-0.5,-1 -0.7,-2.1 -0.7,-3.2c0,-1.2 0.2,-2.3 0.7,-3.3c0.4,-1.1 1,-2 1.8,-2.7c0.7,-0.8 1.6,-1.4 2.7,-1.8c1,-0.5 2.1,-0.7 3.3,-0.7c1.1,0 2.2,0.2 3.2,0.7c1.1,0.4 2,1 2.8,1.8c0.7,0.7 1.3,1.6 1.8,2.7c0.4,1 0.6,2.1 0.6,3.3c0,1.7 -0.5,3.3 -1.5,4.8l4.2,4.1c0.3,0.3 0.4,0.6 0.4,1.1z" id="svg_3"/>
        </g>
      </g>
    </g>
  </svg>
</a></li>
<li class="menu-show static-link"><a href="#">
  <svg width="30" height="30" xmlns="http://www.w3.org/2000/svg" class="svg svg-hamburger">
    <g class="a">
      <g class="b">
        <path d="m5.20682,3l24.8,0l0,4l-25.6,0l0.8,-4zm-2,10l26.8,0l0,4l-27.6,0l0.8,-4zm-1.9,10l28.7,0l0,4l-29.5,0l0.8,-4z"/>
      </g>
    </g>
  </svg>
</a></li>
<li class="menu-hide white"><a href="#">
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


