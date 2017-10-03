<#include "../include/imports.ftl">

<#macro searchbox>
<@hst.setBundle basename="essentials.searchbox"/>
<div class="search-box">
  <div class="container">
    <div class="row">
      <div class="col-xs-12">
        <form id="search-form-global" class="navbar-form" role="search" action="<@hst.link siteMapItemRefId="search" />" method="get">
          <div class="input-group">
            <input class="form-control" placeholder="<@fmt.message key="searchbox.placeholder"/>" aria-label="Text input with multiple buttons" type="s" name="query">
            <div class="input-group-btn">
              <button type="submit" class="btn"><span><@fmt.message key="searchbox.button"/></span>
                <svg xmlns="http://www.w3.org/2000/svg" class="svg svg-search">
                  <g>
                    <g class="a">
                      <g class="b">
                        <path d="m18.8,13.5c0,-1.5 -0.5,-2.8 -1.5,-3.8c-1.1,-1.1 -2.4,-1.6 -3.8,-1.6c-1.5,0 -2.8,0.5 -3.8,1.6c-1.1,1 -1.6,2.3 -1.6,3.8c0,1.4 0.5,2.7 1.6,3.8c1,1 2.3,1.5 3.8,1.5c1.4,0 2.7,-0.5 3.8,-1.5c1,-1.1 1.5,-2.4 1.5,-3.8zm6.2,10c0,0.4 -0.2,0.7 -0.5,1c-0.3,0.3 -0.6,0.5 -1,0.5c-0.5,0 -0.8,-0.2 -1.1,-0.5l-4.1,-4.1c-1.5,1 -3.1,1.5 -4.8,1.5c-1.2,0 -2.3,-0.2 -3.3,-0.6c-1.1,-0.5 -2,-1.1 -2.7,-1.8c-0.8,-0.8 -1.4,-1.7 -1.8,-2.8c-0.5,-1 -0.7,-2.1 -0.7,-3.2c0,-1.2 0.2,-2.3 0.7,-3.3c0.4,-1.1 1,-2 1.8,-2.7c0.7,-0.8 1.6,-1.4 2.7,-1.8c1,-0.5 2.1,-0.7 3.3,-0.7c1.1,0 2.2,0.2 3.2,0.7c1.1,0.4 2,1 2.8,1.8c0.7,0.7 1.3,1.6 1.8,2.7c0.4,1 0.6,2.1 0.6,3.3c0,1.7 -0.5,3.3 -1.5,4.8l4.2,4.1c0.3,0.3 0.4,0.6 0.4,1.1z" id="svg_3"/>
                      </g>
                    </g>
                  </g>
                </svg>
              </button>
              <a href="#" class="btn search-toggle">
                <svg xmlns="http://www.w3.org/2000/svg" class="svg svg-close">
                  <g>
                    <g class="a">
                      <g class="b">
                        <path d="m15,12.2l-9.2,-9.2l-2.8,2.8l9.2,9.2l-9.2,9.2l2.8,2.8l9.2,-9.2l9.2,9.2l2.8,-2.8l-9.2,-9.2l9.2,-9.2l-2.8,-2.8l-9.2,9.2z"/>
                      </g>
                    </g>
                  </g>
                </svg>
              </a>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
</#macro>