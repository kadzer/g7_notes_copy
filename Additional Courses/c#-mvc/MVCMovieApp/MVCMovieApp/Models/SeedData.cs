using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.DependencyInjection;
using System.Linq;

namespace MVCMovieApp.Models
{
    public class SeedData
    {
        public static void Initialize(IServiceProvider serviceProvider)
        {
            using (var context = new MvcMovieContext(
            serviceProvider.GetRequiredService<DbContextOptions<MvcMovieContext>>()))
            {
                if (context.Movies.Any())
                {
                    return;
                }

                context.Movies.AddRange(
                    new Movie
                    {
                        Title = "Halloween",
                        ReleaseDate = DateTime.Parse("1978/10/01"),
                        Genre = "Horror",
                        Price = 7.99M

                    },
                    new Movie
                    {
                        Title = "GhostBusters",
                        ReleaseDate = DateTime.Parse("1984/03/13"),
                        Genre = "Comedy",
                        Price = 8.99M
                    },
                    new Movie
                    {
                        Title = "GhostBusters 2",
                        ReleaseDate = DateTime.Parse("1986/02/21"),
                        Genre = "Comedy",
                        Price = 9.99M
                    }

                );
                context.SaveChanges();
            }
        }
    }
}
