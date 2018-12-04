For this you can follow this online tutorial.

[MVC Web App](https://docs.microsoft.com/en-us/aspnet/core/tutorials/first-mvc-app-mac/start-mvc?view=aspnetcore-2.1)

Main difference is when it gets to scaffolding in the `Add a Model section`.
In the MvcMovie.csproj add the following instead of what it tells you in the tutorial.

```xml
<ItemGroup>
    <PackageReference Include="Microsoft.VisualStudio.Web.CodeGeneration.Design" Version="2.1.1" />
    <PackageReference Include="Microsoft.AspNetCore.App" />
    <PackageReference Include="Microsoft.EntityFrameworkCore.SqlServer" Version="2.1.1" />
    <PackageReference Include="Microsoft.EntityFrameworkCore.Sqlite" Version="2.1.1" />
  </ItemGroup>

    <ItemGroup>
        <DotNetCliToolReference Include="Microsoft.EntityFrameworkCore.Tools.DotNet" Version="2.0.0" />
        <DotNetCliToolReference Include="Microsoft.VisualStudio.Web.CodeGeneration.Tools" Version="2.0.0" />
    </ItemGroup>
```
