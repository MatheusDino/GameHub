# build_all.ps1
$services = @(
    "GameHub_Service_Discovery",
    "GameHub_ServiceOne",
    "GameHub_ServiceTwo", 
    "GameHub_Service_Gateway"
)

foreach ($service in $services) {
    Write-Host "`nBuilding $service..." -ForegroundColor Cyan
    cd $service
    gradle clean build
    cd ..
    if ($LASTEXITCODE -ne 0) {
        Write-Host "Build failed for $service!" -ForegroundColor Red
        exit 1
    }
}

Write-Host "`nAll services built successfully!" -ForegroundColor Green