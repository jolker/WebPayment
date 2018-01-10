
        <div class="row justify-content-md-center">
          <div class="col-12 col-md-5 col-lg-6">
            <div class="row" style="margin-top: 20px;">
              <div class="col-12">
                <p class="title-network">Chọn nhà mạng:</p>
              </div>
            </div>
            <div class="w-100"></div>
            <div class="col mobile-only padding-0">
              <select class="custom-select mobile-select-telco">
                <option value="">Nhà mạng</option>
                <option value="mobi">MOBIFONE</option>
                <option value="vina">VINAPHONE</option>
                <option value="viettel">VIETTEL</option>
              </select>
            </div>
            <div class="row text-center desktop-only">
              <div class="col">
                <div class="btn-network btn-mobi" data-telco="mobi">
                  <img src="${root_url}img/mobi.png" class="img-fluid" alt="">
                </div>
              </div>
              <div class="col">
                <div class="btn-network btn-vina" data-telco="vina">
                  <img src="${root_url}img/vina.png" class="img-fluid" alt="">
                </div>
              </div>
              <div class="col">
                <div class="btn-network btn-viettel" data-telco="viettel">
                  <img src="${root_url}img/viettel.png" class="img-fluid" alt="">
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-12">
                <em class="warning-network">*Lưu ý: Tỷ giá trên chỉ áp dụng với thuê bao <span class="name-network">MOBIFONE</span></em>
              </div>
            </div>
            <div class="row" style="margin-top: 20px;">
              <div class="col">
                <p class="title-network">Chọn mệnh giá:</p>
              </div>
              <div class="w-100"></div>
              <div class="col">
                <select class="custom-select value-sms">
                  <option value="" selected>Mệnh giá</option>
                  <option value="3000">3.000</option>
                  <option value="5000">5.000</option>
                  <option value="10000">10.000</option>
                  <option value="15000">15.000</option>
                  <option value="20000">20.000</option>
                  <option value="50000">50.000</option>
                  <option value="100000">100.000</option>
                </select>
              </div>
            </div>
            <div class="row" style="margin-top: 20px;">
              <div class="col">
                <p class="title-network">Cú pháp:</p>
              </div>
              <div class="w-100"></div>
              <div class="col">
                <div class="input-group">
                  <input id="copy_sms" type="text" class="form-control" value="" style="border-top-left-radius: 50px; border-bottom-left-radius: 50px;">
                  <span class="input-group-btn">
                    <button class="btn btn-primary btn-copy-clipboard" type="button" data-clipboard-target="#copy_sms"><i class="fa fa-clipboard" aria-hidden="true"></i> Copy</button>
                  </span>
                </div>
              </div>
            </div>
          </div>

          <div class="col-12 col-md-7 col-lg-6 table-exchange">
            <!-- viettel -->
            <div class="row viettel">
              <div class="col-3 th-table-exchange" style="border-top-left-radius: 10px;">Mệnh Giá</div>
              <div class="col-3 text-center th-table-exchange line-left-right">Khuyến Mãi</div>
              <div class="col-6 text-right th-table-exchange" style="border-top-right-radius: 10px;">Ncoin</div>
              <#if sms_vt??>
                <#list sms_vt as item>
                  <div class="w-100"></div>
                  <div class="col-3 item-table-exchange format-money" data-pack="${item.pack}">${item.pack}</div>
                  <#if item.promotion != "0">
                    <div class="col-3 text-center item-table-exchange line-left-right" style="color: red">${item.promotion} %</div>
                    <div class="col-6 text-right item-table-exchange" style="color: red"><del class="format-money">${item.ncoin}</del> - <span class="format-money">${item.ncoin?number * item.promotion?number / 100 + item.ncoin?number}</span></div>
                  <#else>
                    <div class="col-3 text-center item-table-exchange line-left-right">${item.promotion} %</div>
                    <div class="col-6 text-right item-table-exchange format-money">${item.ncoin}</div>
                  </#if>
                </#list>
              <#else>
                <div class="w-100"></div>
                <div class="col item-table-exchange">No Data</div>
              </#if>
              <div class="w-100"></div>
              <div class="col-3 item-table-exchange" style="border-bottom-left-radius: 10px;"></div>
              <div class="col-3 text-center item-table-exchange line-left-right"></div>
              <div class="col-6 text-right item-table-exchange" style="border-bottom-right-radius: 10px;"></div>
            </div>

            <!-- mobiphone -->
            <div class="row mobiphone">
              <div class="col-3 th-table-exchange" style="border-top-left-radius: 10px;">Mệnh Giá</div>
              <div class="col-3 text-center th-table-exchange line-left-right">Khuyến Mãi</div>
              <div class="col-6 text-right th-table-exchange" style="border-top-right-radius: 10px;">Ncoin</div>
              <#if sms_mb??>
                <#list sms_mb as item>
                  <div class="w-100"></div>
                  <div class="col-3 item-table-exchange format-money" data-pack="${item.pack}">${item.pack}</div>
                  <#if item.promotion != "0">
                    <div class="col-3 text-center item-table-exchange line-left-right" style="color: red">${item.promotion} %</div>
                    <div class="col-6 text-right item-table-exchange" style="color: red"><del class="format-money">${item.ncoin}</del> - <span class="format-money">${item.ncoin?number * item.promotion?number / 100 + item.ncoin?number}</span></div>
                  <#else>
                    <div class="col-3 text-center item-table-exchange line-left-right">${item.promotion} %</div>
                    <div class="col-6 text-right item-table-exchange format-money">${item.ncoin}</div>
                  </#if>
                </#list>
              <#else>
                <div class="w-100"></div>
                <div class="col item-table-exchange">No Data</div>
              </#if>
              <div class="w-100"></div>
              <div class="col-3 item-table-exchange" style="border-bottom-left-radius: 10px;"></div>
              <div class="col-3 text-center item-table-exchange line-left-right"></div>
              <div class="col-6 text-right item-table-exchange" style="border-bottom-right-radius: 10px;"></div>
            </div>

            <!-- vinaphone -->
            <div class="row vinaphone">
              <div class="col-3 th-table-exchange" style="border-top-left-radius: 10px;">Mệnh Giá</div>
              <div class="col-3 text-center th-table-exchange line-left-right">Khuyến Mãi</div>
              <div class="col-6 text-right th-table-exchange" style="border-top-right-radius: 10px;">Ncoin</div>
              <#if sms_vn??>
                <#list sms_vn as item>
                  <div class="w-100"></div>
                  <div class="col-3 item-table-exchange format-money" data-pack="${item.pack}">${item.pack}</div>
                  <#if item.promotion != "0">
                    <div class="col-3 text-center item-table-exchange line-left-right" style="color: red">${item.promotion} %</div>
                    <div class="col-6 text-right item-table-exchange" style="color: red"><del class="format-money">${item.ncoin}</del> - <span class="format-money">${item.ncoin?number * item.promotion?number / 100 + item.ncoin?number}</span></div>
                  <#else>
                    <div class="col-3 text-center item-table-exchange line-left-right">${item.promotion} %</div>
                    <div class="col-6 text-right item-table-exchange format-money">${item.ncoin}</div>
                  </#if>
                </#list>
              <#else>
                <div class="w-100"></div>
                <div class="col item-table-exchange">No Data</div>
              </#if>
              <div class="w-100"></div>
              <div class="col-3 item-table-exchange" style="border-bottom-left-radius: 10px;"></div>
              <div class="col-3 text-center item-table-exchange line-left-right"></div>
              <div class="col-6 text-right item-table-exchange" style="border-bottom-right-radius: 10px;"></div>
            </div>
          </div>
        </div>
        <script src="${root_url}custom/js/paySmsPage.js"></script>
